package com.upgrad.Grofers.api.controllers;

import com.upgrad.Grofers.api.CategoriesListResponse;
import com.upgrad.Grofers.api.CategoryDetailsResponse;
import com.upgrad.Grofers.api.CategoryListResponse;
import com.upgrad.Grofers.api.ItemList;
import com.upgrad.Grofers.service.business.CategoryService;
import com.upgrad.Grofers.service.entity.CategoryEntity;
import com.upgrad.Grofers.service.entity.ItemEntity;
import com.upgrad.Grofers.service.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * A controller method to get all address from the database.
     *
     * @param categoryId - The uuid of the category whose detail is asked from the database..
     * @return - ResponseEntity<CategoryDetailsResponse> type object along with Http status OK.
     * @throws CategoryNotFoundException
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{category_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CategoryDetailsResponse> getCategoryById(@PathVariable("category_id") String categoryId) throws CategoryNotFoundException {
        final CategoryEntity category = categoryService.getCategoryById(categoryId);
        List<ItemEntity> items = category.getItems();
        Comparator<ItemEntity> compareByItemName = new Comparator<ItemEntity>() {
            @Override
            public int compare(ItemEntity i1, ItemEntity i2) {
                return i1.getItemName().toLowerCase().compareTo(i2.getItemName().toLowerCase());
            }
        };
        Collections.sort(items, compareByItemName);
        List<ItemList> itemLists = new ArrayList<ItemList>();

        CategoryDetailsResponse categoryDetailsResponse = new CategoryDetailsResponse();
        categoryDetailsResponse.id(UUID.fromString(category.getUuid())).categoryName(category.getCategoryName()).itemList(itemLists);

        return new ResponseEntity<CategoryDetailsResponse>(categoryDetailsResponse, HttpStatus.OK);

    }

    /**
     * A controller method to get all categories from the database.
     *
     * @return - ResponseEntity<CategoriesListResponse> type object along with Http status OK.
     */
    @RequestMapping(method = RequestMethod.GET, path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CategoriesListResponse> getAllCategories() {
        final List<CategoryEntity> categories = categoryService.getAllCategoriesOrderedByName();
        Comparator<CategoryEntity> compareByCategoryName = new Comparator<CategoryEntity>() {
            @Override
            public int compare(CategoryEntity c1, CategoryEntity c2) {
                return c1.getCategoryName().compareTo(c2.getCategoryName());
            }
        };
        Collections.sort(categories, compareByCategoryName);
        CategoriesListResponse categoriesListResponse = new CategoriesListResponse();
        for (CategoryEntity category : categories) {
            CategoryListResponse categoryListResponse = new CategoryListResponse();
            categoryListResponse.id(UUID.fromString(category.getUuid())).categoryName(category.getCategoryName());
            categoriesListResponse.addCategoriesItem(categoryListResponse);
        }
        return new ResponseEntity<CategoriesListResponse>(categoriesListResponse, HttpStatus.OK);

    }
}
