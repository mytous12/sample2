package com.upgrad.Grofers.service.dao;

import com.upgrad.Grofers.service.entity.ItemEntity;

import java.util.List;

/*
 * This ItemDao interface gives the list of all the dao methods that exist in the item dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
public interface ItemDao {

    List<ItemEntity> getItemsByCategoryAndStore(String storeId, String categoryId);
}
