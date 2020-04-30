package com.upgrad.Grofers.service.dao;

import com.upgrad.Grofers.service.entity.StoreEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * StoreDao class provides the database access for all the endpoints in Store controller.
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao{

    //When a container of the application(be it a Java EE container or any other custom container like Spring) manages the lifecycle of the Entity Manager, the Entity Manager is said to be Container Managed. The most common way of acquiring a Container Managed EntityManager is to use @PersistenceContext annotation on an EntityManager attribute.
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public  StoreEntity storeByUUID(String storeId) {
        try {
            return entityManager.createNamedQuery("storesByUUID", StoreEntity.class).setParameter("storeId", storeId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public  List<StoreEntity> storeByName(String storeName) {
        try {
            return entityManager.createNamedQuery("storesByName", StoreEntity.class).setParameter("storeName", storeName).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<StoreEntity> storeByRating() {
        try {
            return entityManager.createNamedQuery("storesByRating", StoreEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<StoreEntity> storeByCategory(String categoryId) {
        try {
            return entityManager.createNamedQuery("storesByCategory", StoreEntity.class).setParameter("uuid",categoryId).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
