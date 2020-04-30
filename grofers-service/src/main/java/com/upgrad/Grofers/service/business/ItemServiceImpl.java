package com.upgrad.Grofers.service.business;


import com.upgrad.Grofers.service.dao.ItemDao;
import com.upgrad.Grofers.service.dao.StoreDao;
import com.upgrad.Grofers.service.entity.CategoryEntity;
import com.upgrad.Grofers.service.entity.ItemEntity;
import com.upgrad.Grofers.service.entity.StoreEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemDao itemDao;
    private final StoreDao storeDao;

    public ItemServiceImpl(ItemDao itemDao, StoreDao storeDao) {
        this.itemDao = itemDao;
        this.storeDao = storeDao;
    }

    /**
     * The method implements the business logic for getting list of items based on store and category uuid.
     */
    @Override
    public List<ItemEntity> getItemsByCategoryAndStore(String storeId, String categoryId) {
//        return itemDao.getItemsByCategoryAndStore(storeId, categoryId);
        StoreEntity storeEntity = storeDao.storeByUUID(storeId);

        List<CategoryEntity> categoryEntities = storeEntity.getCategories();

        for (CategoryEntity categoryEntity : categoryEntities) {
            if (categoryEntity.getUuid().equals(categoryId)) {
                return categoryEntity.getItems();
            }
        }
        return null;
    }

}
