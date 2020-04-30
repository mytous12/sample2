package com.upgrad.Grofers.service.dao;

import com.upgrad.Grofers.service.entity.StateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StateDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StateEntity> getAllStates() {

        try {
            return this.entityManager.createNamedQuery("allStates", StateEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public StateEntity getStateByStateUuid(String stateUuid) {
        try {
            return entityManager.createNamedQuery("stateByStateUuid", StateEntity.class).setParameter("stateUuid", stateUuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public StateEntity getStateById(long stateUuid) {
        try {
            return entityManager.createNamedQuery("getStateById", StateEntity.class).setParameter("id", stateUuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}