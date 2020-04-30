package com.upgrad.Grofers.service.business;


import com.upgrad.Grofers.service.dao.CategoryDao;
import com.upgrad.Grofers.service.dao.StoreDao;
import com.upgrad.Grofers.service.entity.CategoryEntity;
import com.upgrad.Grofers.service.entity.StoreEntity;
import com.upgrad.Grofers.service.exception.CategoryNotFoundException;
import com.upgrad.Grofers.service.exception.StoreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao StoreDao;

    @Autowired
    private CategoryDao categoryDao;

    /**
     * The method implements the business logic for getting Store details by Store uuid.
     * @return
     */
    @Override
    public StoreEntity storeByUUID(String StoreId) throws StoreNotFoundException {
        return null;
    }

    /**
     * The method implements the business logic for getting Stores by Store name.
     * @return
     */
    @Override
    public List<StoreEntity> storesByName(String StoreName) throws StoreNotFoundException {
        if (StoreName.isEmpty()) {
            throw new StoreNotFoundException("RNF-003", "Store name field should not be empty");
        }
        List<StoreEntity> storeEntityList = StoreDao.storeByName(StoreName);
        return storeEntityList;

    }

    /**
     * The method implements the business logic for getting all Stores ordered by their rating.
     */
    @Override

        public List<StoreEntity> storesByRating() {
            return StoreDao.storeByRating();
        }



    /**
     * The method implements the business logic for getting Stores by their category.
     * @return
     */
    @Override
    public List<StoreEntity> storeByCategory(String categoryId) throws CategoryNotFoundException {
        if (categoryId.isEmpty()) {
            throw new CategoryNotFoundException("CNF-001", "Category id field should not be empty");
        }
        CategoryEntity categoryEntity = categoryDao.getCategoryById(categoryId);
        if (categoryEntity == null) {
            throw new CategoryNotFoundException("CNF-002", "No category by this id");
        }
        List<StoreEntity> storeEntityList = categoryEntity.getStores();
        return storeEntityList;
    }

}
