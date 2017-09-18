/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.rest;

import com.sv.orderapp.rest.request.MDepartmentRequest;
import com.sv.orderapp.rest.request.MItemRequest;
import com.sv.orderapp.rest.request.MMainCategoryRequest;
import com.sv.orderapp.rest.request.MRouteRequest;
import com.sv.orderapp.rest.request.MSubCategoryRequest;
import com.sv.orderapp.rest.request.MTransactorRequest;
import com.sv.orderapp.rest.request.MUserRequest;
import java.util.List;

/**
 *
 * @author Mohan
 */
public interface RestService {

    public List<MDepartmentRequest> listDepartments();

    public List<MMainCategoryRequest> listMainCategories();

    public List<MSubCategoryRequest> listSubCategories();

    public List<MItemRequest> listItems();

    public List<MRouteRequest> listRoutes();

    public List<MTransactorRequest> listClients();

    public List<MUserRequest> listUsers();
}
