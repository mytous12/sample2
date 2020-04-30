package com.upgrad.Grofers.service.dao;


import com.upgrad.Grofers.service.entity.StoreEntity;

import java.util.List;

/*
 * This StoreDao interface gives the list of all the dao methods that exist in the store dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
public interface StoreDao {

    StoreEntity storeByUUID(String storeId);
    List<StoreEntity> storeByName(String storeName);
    List<StoreEntity> storeByRating();
    List<StoreEntity> storeByCategory(String categoryId);
}
