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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mohan
 */
@Controller
public class RestController {

    @Autowired
    private RestService restService;

    @RequestMapping("/rest-api/list-department")
    public @ResponseBody
    List<MDepartmentRequest> listDepartments() {
        return restService.listDepartments();
    }

    @RequestMapping("/rest-api/list-main-category")
    public @ResponseBody
    List<MMainCategoryRequest> listMainCategories() {
        return restService.listMainCategories();
    }

    @RequestMapping("/rest-api/list-sub-category")
    public @ResponseBody
    List<MSubCategoryRequest> listSubCategories() {
        return restService.listSubCategories();
    }

    @RequestMapping("/rest-api/list-item")
    public @ResponseBody
    List<MItemRequest> listItems() {
        return restService.listItems();
    }

    @RequestMapping("/rest-api/list-route")
    public @ResponseBody
    List<MRouteRequest> listRoutes() {
        return restService.listRoutes();
    }

    @RequestMapping("/rest-api/list-client")
    public @ResponseBody
    List<MTransactorRequest> listClient() {
        return restService.listClients();
    }

    @RequestMapping("/rest-api/list-user")
    public @ResponseBody
    List<MUserRequest> listUsers() {
        return restService.listUsers();
    }

}
