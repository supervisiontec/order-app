/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.item_manager;

import com.sv.orderapp.item_manager.model.MDepartment;
import com.sv.orderapp.item_manager.model.MItem;
import com.sv.orderapp.item_manager.model.MMainCategory;
import com.sv.orderapp.item_manager.model.MSubCategory;
import com.sv.orderapp.item_manager.model.MTransactor;
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
public class ItemManagerReposirotyImpl implements ItemManagerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MDepartment> listDepartments() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MDepartment.class).list();
    }

    @Override
    public List<MMainCategory> listMainCategories(Integer department) {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MMainCategory.class).add(Restrictions.eq("department", department)).list();
    }

    @Override
    public List<MSubCategory> listSubCategories(Integer mainCategory) {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MSubCategory.class).add(Restrictions.eq("mainCategory", mainCategory)).list();
    }

    @Override
    public List<MTransactor> listSuppliers() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MTransactor.class)
                .add(Restrictions.eq("supplier", true))
                .add(Restrictions.eq("active", true))
                .list();
    }

    @Override
    public List<MItem> listItems() {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(MItem.class)
                .list();
    }

    @Override
    public Serializable newObject(Object object) {
        Session session = sessionFactory.getCurrentSession();

        return session.save(object);
    }

    @Override
    public Serializable updateObject(Object object) {
        Session session = sessionFactory.getCurrentSession();

        session.update(object);
        
        return null;
    }

    @Override
    public Object getObject(Class cls, Serializable id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(cls, id);
    }

    @Override
    public Boolean toggleActivationItem(Serializable code) {
        Session session = sessionFactory.getCurrentSession();

        MItem item = (MItem) session.load(MItem.class, code);
        item.setActive(!item.isActive());

        session.update(item);

        return item.isActive();
    }

    @Override
    public Boolean deleteItem(Serializable code) {
        Session session = sessionFactory.getCurrentSession();

        MItem item = (MItem) session.load(MItem.class, code);

        try {
            session.delete(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
