/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.customer_control_panel;

import com.sv.orderapp.customer_control_panel.model.MTransactor;
import java.io.Serializable;
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
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MTransactor> listTransactors() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MTransactor.class).add(Restrictions.eq("client", true)).list();
    }

    @Override
    public List<MTransactor> listPendingTransactors() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MTransactor.class)
                .add(Restrictions.eq("client", true))
                .add(Restrictions.eq("approved", false))
                .list();
    }

    @Override
    public List listObjects(Class cls) {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(cls).list();
    }

    @Override
    public Object getObject(Class cls, Serializable id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(cls, id);
    }

    @Override
    public Serializable newObject(Object object) {
        Session session = sessionFactory.getCurrentSession();

        return session.save(object);
    }

    @Override
    public void updateObject(Object object) {
        Session session = sessionFactory.getCurrentSession();

        session.update(object);
    }

    @Override
    public void deleteObject(Object object) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(object);
    }
}
