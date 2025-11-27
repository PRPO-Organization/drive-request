package com.skupina1.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RideRequestRepository {

    @Inject
    EntityManager em;

    @Transactional
    public RideRequestEntity save(RideRequestEntity entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    public RideRequestEntity findById(long id){
        return em.find(RideRequestEntity.class, id);
    }

    @Transactional
    public RideRequestEntity update(RideRequestEntity entity){
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }
}
