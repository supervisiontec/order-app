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
import com.sv.orderapp.item_manager.request.NewItemRequest;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mohan
 */
public interface ItemManagerService {

    public List<MDepartment> listDepartments();

    public List<MMainCategory> listMainCategories(Integer department);

    public List<MSubCategory> listSubCategories(Integer mainCategory);

    public List<MTransactor> listSuppliers();

    public List<MItem> listItems();

    public Integer newDepartment(String name);

    public Integer newMainCategory(Integer department, String name);

    public Integer newSubCategory(Integer mainCategory, String name);

    public Serializable newItem(NewItemRequest newItemRequest);

    public Serializable updateItem(NewItemRequest newItemRequest);

    public MItem getItem(Serializable indexNo);

    public Boolean toggleActivationItem(Serializable indexNo);

    public Boolean deleteItem(Serializable indexNo);
}
