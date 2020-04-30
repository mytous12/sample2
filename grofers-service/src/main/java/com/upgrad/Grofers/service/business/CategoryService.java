package com.upgrad.Grofers.service.business;


import com.upgrad.Grofers.service.entity.CategoryEntity;
import com.upgrad.Grofers.service.exception.CategoryNotFoundException;

import java.util.List;

/*
 * This CategoryService interface gives the list of all the service that exist in the category service implementation class.
 * Controller class will be calling the service methods by this interface.
 */
public interface CategoryService {

    CategoryEntity getCategoryById(String categoryId) throws CategoryNotFoundException;
    List<CategoryEntity> getAllCategoriesOrderedByName();
    List<CategoryEntity> getCategoriesByStores(String storeId);
}
