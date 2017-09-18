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

/**
 *
 * @author Mohan
 */
public interface ItemManagerRepository {

    public List<MDepartment> listDepartments();

    public List<MMainCategory> listMainCategories(Integer department);

    public List<MSubCategory> listSubCategories(Integer mainCategory);

    public List<MTransactor> listSuppliers();

    public List<MItem> listItems();

    public Serializable newObject(Object object);
    
    public Serializable updateObject(Object object);

    public Object getObject(Class cls, Serializable id);

    public Boolean toggleActivationItem(Serializable code);

    public Boolean deleteItem(Serializable code);
}
