package com.upgrad.Grofers.service.business;

import com.upgrad.Grofers.service.dao.CategoryDao;
import com.upgrad.Grofers.service.dao.StoreDao;
import com.upgrad.Grofers.service.entity.CategoryEntity;
import com.upgrad.Grofers.service.entity.StoreEntity;
import com.upgrad.Grofers.service.exception.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final StoreDao storeDao;

    public CategoryServiceImpl(CategoryDao categoryDao, StoreDao storeDao) {
        this.categoryDao = categoryDao;
        this.storeDao = storeDao;
    }

    /**
     * The method implements the business logic for getting category by its id endpoint.
     */
    @Override
    public CategoryEntity getCategoryById(String categoryId) throws CategoryNotFoundException {
        if (categoryId.isEmpty()) {
            throw new CategoryNotFoundException("CNF-001", "Category id field should not be empty");
        }
        CategoryEntity categoryEntity = categoryDao.getCategoryById(categoryId);
        if (categoryEntity == null) {
            throw new CategoryNotFoundException("CNF-002", "No category by this id");
        }
        CategoryEntity category = categoryDao.getCategoryById(categoryId);
        return category;
    }

    /**
     * The method implements the business logic for getting all categories ordered by their name endpoint.
     */
    @Override
    public List<CategoryEntity> getAllCategoriesOrderedByName() {
        List<CategoryEntity> categoryEntities = categoryDao.getAllCategoriesOrderedByName();
        return categoryEntities;
    }

    /**
     * The method implements the business logic for getting categories for any particular store.
     */
    @Override
    public List<CategoryEntity> getCategoriesByStores(String storeId) {
        StoreEntity storeEntity = storeDao.storeByUUID(storeId);

        List<CategoryEntity> categoryEntities = storeEntity.getCategories();

        return categoryEntities;
    }
}
