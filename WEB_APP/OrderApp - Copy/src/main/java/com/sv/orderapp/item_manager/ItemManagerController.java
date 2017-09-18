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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mohan
 */
@Controller
public class ItemManagerController {

    @Autowired
    private ItemManagerService itemManagerService;

    //start views
    @RequestMapping("/item-form/new")
    public ModelAndView attemptItemForm() {
        ModelAndView modelAndView = new ModelAndView("item-control-panel/item-form");

        modelAndView.addObject("action", "new");
        
        return modelAndView;
    }

    @RequestMapping("/item-form/{action}/{indexNo}")
    public ModelAndView attemptItemForm(
            @PathVariable String action,
            @PathVariable Integer indexNo
    ) {
        ModelAndView modelAndView = new ModelAndView("item-control-panel/item-form");

        modelAndView.addObject("item", itemManagerService.getItem(indexNo));
        modelAndView.addObject("action", action);

        return modelAndView;
    }

    @RequestMapping("/item-list")
    public ModelAndView attemptItemList() {
        ModelAndView modelAndView = new ModelAndView("/item-control-panel/item-list");

        modelAndView.addObject("items", itemManagerService.listItems());

        return modelAndView;
    }
    //end views

    //start rest api
    //start listing
    @RequestMapping("/rest/list-department")
    public @ResponseBody
    List<MDepartment> listDepartments() {
        return itemManagerService.listDepartments();
    }

    @RequestMapping("/rest/list-main-categories/{department}")
    public @ResponseBody
    List<MMainCategory> listMainCategories(@PathVariable Integer department) {
        return itemManagerService.listMainCategories(department);
    }

    @RequestMapping("/rest/list-sub-categories/{mainCategory}")
    public @ResponseBody
    List<MSubCategory> listSubCategories(@PathVariable Integer mainCategory) {
        return itemManagerService.listSubCategories(mainCategory);
    }

    @RequestMapping("/rest/list-suppliers")
    public @ResponseBody
    List<MTransactor> listSuppliers() {
        return itemManagerService.listSuppliers();
    }

    @RequestMapping("/rest/list-item")
    public @ResponseBody
    List<MItem> listItems() {
        return itemManagerService.listItems();
    }
    //end listing

    //start saving
    @RequestMapping("/rest/new-department/{name}")
    public @ResponseBody
    Integer newDepartment(@PathVariable String name) {
        return itemManagerService.newDepartment(name);
    }

    @RequestMapping("/rest/new-main-category/{name}/{department}")
    public @ResponseBody
    Integer newMainCategory(@PathVariable String name, @PathVariable Integer department) {
        return itemManagerService.newMainCategory(department, name);
    }

    @RequestMapping("/rest/new-sub-category/{name}/{mainCategory}")
    public @ResponseBody
    Integer newSubCategory(@PathVariable String name, @PathVariable Integer mainCategory) {
        return itemManagerService.newSubCategory(mainCategory, name);
    }

    @RequestMapping("/rest/new-item")
    public @ResponseBody
    Integer newItem(@RequestBody NewItemRequest item) {
        return (Integer) itemManagerService.newItem(item);
    }

    @RequestMapping("/rest/update-item")
    public @ResponseBody
    Integer updateItem(@RequestBody NewItemRequest item) {
        return (Integer) itemManagerService.updateItem(item);
    }

    @RequestMapping("/rest/toggle-activation-item/{indexNo}")
    public @ResponseBody
    Boolean toggleItemActivation(@PathVariable Integer indexNo) {
        return itemManagerService.toggleActivationItem(indexNo);
    }

    @RequestMapping("/rest/delete-item/{indexNo}")
    public @ResponseBody
    Boolean deleteItem(@PathVariable Integer indexNo) {
        return itemManagerService.deleteItem(indexNo);
    }

    //end saving
    //end rest api
}
