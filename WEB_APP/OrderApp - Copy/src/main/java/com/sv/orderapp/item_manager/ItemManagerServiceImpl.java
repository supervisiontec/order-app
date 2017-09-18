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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohan
 */
@Service
@Transactional
public class ItemManagerServiceImpl implements ItemManagerService {

    @Autowired
    private ItemManagerRepository itemManagerRepository;

    @Override
    public List<MDepartment> listDepartments() {
        return itemManagerRepository.listDepartments();
    }

    @Override
    public List<MMainCategory> listMainCategories(Integer department) {
        return itemManagerRepository.listMainCategories(department);
    }

    @Override
    public List<MSubCategory> listSubCategories(Integer mainCategory) {
        return itemManagerRepository.listSubCategories(mainCategory);
    }

    @Override
    public List<MTransactor> listSuppliers() {
        return itemManagerRepository.listSuppliers();
    }

    @Override
    public List<MItem> listItems() {
        return itemManagerRepository.listItems();
    }

    @Override
    public Integer newDepartment(String name) {
        MDepartment department = new MDepartment();
        department.setName(name);

        return (Integer) itemManagerRepository.newObject(department);
    }

    @Override
    public Integer newMainCategory(Integer department, String name) {
        MMainCategory mainCategory = new MMainCategory();
        mainCategory.setName(name);
        mainCategory.setDepartment(department);

        return (Integer) itemManagerRepository.newObject(mainCategory);
    }

    @Override
    public Integer newSubCategory(Integer mainCategory, String name) {
        MSubCategory subCategory = new MSubCategory();
        subCategory.setName(name);
        subCategory.setMainCategory(mainCategory);

        return (Integer) itemManagerRepository.newObject(subCategory);
    }

    @Override
    public Serializable newItem(NewItemRequest newItemRequest) {
        MTransactor supplier = (MTransactor) itemManagerRepository.getObject(MTransactor.class, newItemRequest.getSupplier());
        MDepartment department = (MDepartment) itemManagerRepository.getObject(MDepartment.class, newItemRequest.getDepartment());
        MMainCategory mainCategory = (MMainCategory) itemManagerRepository.getObject(MMainCategory.class, newItemRequest.getMainCategory());
        MSubCategory subCategory = (MSubCategory) itemManagerRepository.getObject(MSubCategory.class, newItemRequest.getSubCategory());

        MItem item = new MItem();
        item.setCode(newItemRequest.getCode());
        item.setName(newItemRequest.getName());
        item.setPrintDescription(newItemRequest.getPrintDescription());
        item.setMTransactor(supplier);
        item.setMDepartment(department);
        item.setMMainCategory(mainCategory);
        item.setMSubCategory(subCategory);
        item.setDefaultUnit(newItemRequest.getDefaultUnit());
        item.setCostPrice(newItemRequest.getCostPrice());
        item.setWholeSalePrice(newItemRequest.getWholeSalePrice());
        item.setLastSalePrice(newItemRequest.getLastSalePrice());
        item.setSalePrice(newItemRequest.getSalePrice());
        item.setActive(newItemRequest.isActive());

        return itemManagerRepository.newObject(item);
    }

    @Override
    public Serializable updateItem(NewItemRequest newItemRequest) {
        MTransactor supplier = (MTransactor) itemManagerRepository.getObject(MTransactor.class, newItemRequest.getSupplier());
        MDepartment department = (MDepartment) itemManagerRepository.getObject(MDepartment.class, newItemRequest.getDepartment());
        MMainCategory mainCategory = (MMainCategory) itemManagerRepository.getObject(MMainCategory.class, newItemRequest.getMainCategory());
        MSubCategory subCategory = (MSubCategory) itemManagerRepository.getObject(MSubCategory.class, newItemRequest.getSubCategory());

        MItem item = (MItem) itemManagerRepository.getObject(MItem.class, newItemRequest.getIndexNo());
        item.setCode(newItemRequest.getCode());
        item.setName(newItemRequest.getName());
        item.setPrintDescription(newItemRequest.getPrintDescription());
        item.setMTransactor(supplier);
        item.setMDepartment(department);
        item.setMMainCategory(mainCategory);
        item.setMSubCategory(subCategory);
        item.setDefaultUnit(newItemRequest.getDefaultUnit());
        item.setCostPrice(newItemRequest.getCostPrice());
        item.setWholeSalePrice(newItemRequest.getWholeSalePrice());
        item.setLastSalePrice(newItemRequest.getLastSalePrice());
        item.setSalePrice(newItemRequest.getSalePrice());
        item.setActive(newItemRequest.isActive());

        itemManagerRepository.updateObject(item);
        
        return item.getIndexNo();
    }

    @Override
    public MItem getItem(Serializable code) {
        return (MItem) itemManagerRepository.getObject(MItem.class, code);
    }

    @Override
    public Boolean toggleActivationItem(Serializable code) {
        return itemManagerRepository.toggleActivationItem(code);
    }

    @Override
    public Boolean deleteItem(Serializable code) {
        return itemManagerRepository.deleteItem(code);
    }
}
