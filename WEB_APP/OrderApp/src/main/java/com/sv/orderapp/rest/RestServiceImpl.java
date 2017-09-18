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
import com.sv.orderapp.rest.request.MDepartmentRequest;
import com.sv.orderapp.rest.request.MItemRequest;
import com.sv.orderapp.rest.request.MMainCategoryRequest;
import com.sv.orderapp.rest.request.MRouteRequest;
import com.sv.orderapp.rest.request.MSubCategoryRequest;
import com.sv.orderapp.rest.request.MTransactorRequest;
import com.sv.orderapp.rest.request.MUserRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohan
 */
@Transactional
@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private RestRepository restRepository;
    
    @Override
    public List<MDepartmentRequest> listDepartments() {
        List<MDepartment> departments = restRepository.listDepartments();
        
        List<MDepartmentRequest> departmentRequests = new ArrayList<MDepartmentRequest>();
        for (MDepartment department : departments) {
            MDepartmentRequest departmentRequest = new MDepartmentRequest();
            departmentRequest.setIndexNo(department.getIndexNo());
            departmentRequest.setName(department.getName());
            departmentRequest.setVersion(department.getVersion());
            
            departmentRequests.add(departmentRequest);
        }
        return departmentRequests;
    }

    @Override
    public List<MMainCategoryRequest> listMainCategories() {
        List<MMainCategory> mainCategorys = restRepository.listMainCategories();
        
        List<MMainCategoryRequest> mainCategoryRequests = new ArrayList<MMainCategoryRequest>();
        for (MMainCategory mainCategory : mainCategorys) {
            MMainCategoryRequest mainCategoryRequest = new MMainCategoryRequest();
            mainCategoryRequest.setIndexNo(mainCategory.getIndexNo());
            mainCategoryRequest.setName(mainCategory.getName());
            mainCategoryRequest.setVersion(mainCategory.getVersion());
            
            mainCategoryRequests.add(mainCategoryRequest);
        }
        return mainCategoryRequests;
    }

    @Override
    public List<MSubCategoryRequest> listSubCategories() {
        List<MSubCategory> subCategorys = restRepository.listSubCategories();
        
        List<MSubCategoryRequest> subCategoryRequests = new ArrayList<MSubCategoryRequest>();
        for (MSubCategory subCategory : subCategorys) {
            MSubCategoryRequest subCategoryRequest = new MSubCategoryRequest();
            subCategoryRequest.setIndexNo(subCategory.getIndexNo());
            subCategoryRequest.setName(subCategory.getName());
            subCategoryRequest.setVersion(subCategory.getVersion());
            
            subCategoryRequests.add(subCategoryRequest);
        }
        return subCategoryRequests;
    }

    @Override
    public List<MItemRequest> listItems() {
        List<MItem> items = restRepository.listItems();
        
        List<MItemRequest> itemRequests = new ArrayList<MItemRequest>();
        for (MItem item : items) {
            MItemRequest itemRequest = new MItemRequest();
            
            itemRequest.setIndexNo(item.getIndexNo());
            itemRequest.setCode(item.getCode());
            itemRequest.setName(item.getName());
            itemRequest.setPrintDescription(item.getPrintDescription());
            
            MDepartmentRequest departmentRequest = new MDepartmentRequest();
            departmentRequest.setIndexNo(item.getMDepartment().getIndexNo());
            departmentRequest.setName(item.getMDepartment().getName());
            departmentRequest.setVersion(item.getMDepartment().getVersion());
            itemRequest.setDepartment(departmentRequest);
                        
            
            MMainCategoryRequest mainCategoryRequest = new MMainCategoryRequest();
            mainCategoryRequest.setIndexNo(item.getMMainCategory().getIndexNo());
            mainCategoryRequest.setName(item.getMMainCategory().getName());
            mainCategoryRequest.setVersion(item.getMMainCategory().getVersion());
            itemRequest.setMainCategory(mainCategoryRequest);
            
            
            MSubCategoryRequest subCategoryRequest = new MSubCategoryRequest();
            subCategoryRequest.setIndexNo(item.getMSubCategory().getIndexNo());
            subCategoryRequest.setName(item.getMSubCategory().getName());
            subCategoryRequest.setVersion(item.getMSubCategory().getVersion());
            itemRequest.setSubCategory(subCategoryRequest);
            
            itemRequest.setCostPrice(item.getCostPrice());
            itemRequest.setRetailPrice(item.getRetailPrice());
            itemRequest.setMaxDiscountPercent(item.getMaxDiscountPercent());
            
            itemRequest.setVersion(item.getVersion());
            
            itemRequests.add(itemRequest);
        }
        return itemRequests;
    }

    @Override
    public List<MRouteRequest> listRoutes() {
        List<MRoute> routes = restRepository.listRoutes();
        
        List<MRouteRequest> routeRequests = new ArrayList<MRouteRequest>();
        for (MRoute route : routes) {
            MRouteRequest routeRequest = new MRouteRequest();
            routeRequest.setIndexNo(route.getIndexNo());
            routeRequest.setName(route.getName());
            routeRequest.setVersion(route.getVersion());
            
            routeRequests.add(routeRequest);
        }
        return routeRequests;
    }

    @Override
    public List<MTransactorRequest> listClients() {
        List<MTransactor> users = restRepository.listClients();
        
        List<MTransactorRequest> userRequests = new ArrayList<MTransactorRequest>();
        for (MTransactor transactor : users) {
            MTransactorRequest transactorRequest = new MTransactorRequest();
            
            transactorRequest.setIndexNo(transactor.getIndexNo());
            transactorRequest.setServerId(transactor.getIndexNo());
            transactorRequest.setName(transactor.getName());
            transactorRequest.setContactPerson(transactor.getContactPerson());
            transactorRequest.setAddressLine1(transactor.getAddressLine1());
            transactorRequest.setAddressLine2(transactor.getAddressLine2());
            transactorRequest.setAddressLine3(transactor.getAddressLine3());
            transactorRequest.setMobile(transactor.getMobile());
            transactorRequest.setTelephone1(transactor.getTelephone1());
            transactorRequest.setTelephone2(transactor.getTelephone2());
            transactorRequest.setFax(transactor.getFax());
            transactorRequest.setRoute(transactor.getMRoute().getIndexNo());
            transactorRequest.setCreditAmount(transactor.getCreditAmount());
            transactorRequest.setCreditLimit(transactor.getCreditLimit());
            transactorRequest.setClient(transactor.isClient());
            transactorRequest.setSupplier(transactor.isSupplier());
            transactorRequest.setLastVisitedDate(transactor.getLastVisitedDate());
            transactorRequest.setVersion(transactor.getVersion());
            
            userRequests.add(transactorRequest);
        }
        return userRequests;
    }

    @Override
    public List<MUserRequest> listUsers() {
        List<MUser> users = restRepository.listUsers();
        
        List<MUserRequest> userRequests = new ArrayList<MUserRequest>();
        for (MUser user : users) {
            MUserRequest userRequest = new MUserRequest();
            userRequest.setIndexNo(user.getIndexNo());
            userRequest.setName(user.getName());
            userRequest.setVersion(user.getVersion());
            
            userRequests.add(userRequest);
        }
        return userRequests;
    }

}
