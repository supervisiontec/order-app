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

/**
 *
 * @author Mohan
 */
public interface RestRepository {

    public List<MDepartment> listDepartments();

    public List<MMainCategory> listMainCategories();

    public List<MSubCategory> listSubCategories();

    public List<MItem> listItems();

    public List<MRoute> listRoutes();

    public List<MTransactor> listClients();

    public List<MUser> listUsers();
}
