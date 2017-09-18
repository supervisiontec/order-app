/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.rest;

import com.sv.orderapp.rest.model.MDepartment;
import com.sv.orderapp.rest.model.MItem;
import com.sv.orderapp.rest.model.MMainCategory;
import com.sv.orderapp.rest.model.MRoute;
import com.sv.orderapp.rest.model.MSubCategory;
import com.sv.orderapp.rest.model.MTransactor;
import com.sv.orderapp.rest.model.MUser;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohan
 */
@Repository
public class RestRepositoryImpl implements RestRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MDepartment> listDepartments() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MDepartment.class).list();
    }

    @Override
    public List<MMainCategory> listMainCategories() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MMainCategory.class).list();
    }

    @Override
    public List<MSubCategory> listSubCategories() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MSubCategory.class).list();
    }

    @Override
    public List<MItem> listItems() {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createCriteria(MItem.class)
                .add(Restrictions.eq("active", true))
                .list();
    }

    @Override
    public List<MRoute> listRoutes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MRoute.class).list();
    }

    @Override
    public List<MTransactor> listClients() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createCriteria(MTransactor.class)
                .add(Restrictions.eq("client", true))
                .list();
    }

    @Override
    public List<MUser> listUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createCriteria(MUser.class)
                .add(Restrictions.eq("mobileApp", true))
                .list();
    }

}
