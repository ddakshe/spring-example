package com.example.spring.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    protected JPAQueryFactory queryFactory;

    @PostConstruct
    public void init(){
        queryFactory = new JPAQueryFactory(entityManager);
    }
}
