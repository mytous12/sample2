package com.upgrad.Grofers.service.business;



import com.upgrad.Grofers.service.entity.StoreEntity;
import com.upgrad.Grofers.service.exception.CategoryNotFoundException;
import com.upgrad.Grofers.service.exception.StoreNotFoundException;

import java.util.List;

/*
 * This StoreService interface gives the list of all the service that exist in the Store service implementation class.
 * Controller class will be calling the service methods by this interface.
 */
public interface StoreService {

    StoreEntity storeByUUID(String StoreId) throws StoreNotFoundException;

    List<StoreEntity> storesByName(String StoreName) throws StoreNotFoundException;

     List<StoreEntity> storesByRating();

    List<StoreEntity> storeByCategory(String categoryId) throws CategoryNotFoundException;
}
