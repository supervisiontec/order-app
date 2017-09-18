/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.user_control_panel;

import com.sv.orderapp.supplier_control_panel.request.NewTransactorRequest;
import com.sv.orderapp.user_control_panel.request.NewUserRequest;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user-form/new")
    public ModelAndView attemtUserform() {
        ModelAndView modelAndView = new ModelAndView("user-control-panel/user-form");

        modelAndView.addObject("action", "new");

        return modelAndView;
    }

    @RequestMapping("/user-form/{action}/{indexNo}")
    public ModelAndView attemtUserform(
            @PathVariable String action,
            @PathVariable Integer indexNo) {
        ModelAndView modelAndView = new ModelAndView("user-control-panel/user-form");

        modelAndView.addObject("action", action);
        modelAndView.addObject("user", userService.getUser(indexNo));

        return modelAndView;
    }

    @RequestMapping("/user-list")
    public ModelAndView attemtUserList() {
        ModelAndView modelAndView = new ModelAndView("user-control-panel/user-list");

        modelAndView.addObject("users", userService.listUsers());

        return modelAndView;
    }

    @RequestMapping("/rest/new-user")
    public @ResponseBody
    Integer newTransactor(@RequestBody NewUserRequest userRequest) {
        return (Integer) userService.newUser(userRequest);
    }

    @RequestMapping("/rest/update-user")
    public @ResponseBody
    Integer updateTransactor(@RequestBody NewUserRequest userRequest) {
        return (Integer) userService.updateUser(userRequest);
    }

    @RequestMapping("/rest/toggle-activation-user/{indexNo}")
    public @ResponseBody
    Boolean toggleActivation(@PathVariable Integer indexNo) {
        return userService.toggleActivationUser(indexNo);
    }

    @RequestMapping("/rest/delete-user/{indexNo}")
    public @ResponseBody
    Boolean deleteItem(@PathVariable Integer indexNo) {
        return userService.deleteUser(indexNo);
    }
}
