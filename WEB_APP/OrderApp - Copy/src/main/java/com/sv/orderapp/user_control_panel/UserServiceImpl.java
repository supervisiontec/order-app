/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.user_control_panel;

import com.sv.orderapp.user_control_panel.model.MUser;
import com.sv.orderapp.user_control_panel.request.NewUserRequest;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<MUser> listUsers() {
        return userRepository.listUsers();
    }

    @Override
    public Serializable newUser(NewUserRequest request) {
        MUser user = new MUser();
        user.setName(request.getName());
        user.setItemControlPanel(request.isItemControlPanel());
        user.setCustomerControlPanel(request.isCustomerControlPanel());
        user.setSupplierControlPanel(request.isSupplierControlPanel());
        user.setUserControlPanel(request.isUserControlPanel());
        user.setCustomerApproval(request.isCustomerApproval());
        user.setOrderApproval(request.isOrderApproval());
        user.setReports(request.isReports());
        user.setMobileApp(request.isMobileApp());

        return userRepository.newObject(user);
    }

    @Override
    public Serializable updateUser(NewUserRequest request) {
        MUser user = (MUser) userRepository.getObject(MUser.class, request.getIndexNo());

        user.setName(request.getName());
        user.setItemControlPanel(request.isItemControlPanel());
        user.setCustomerControlPanel(request.isCustomerControlPanel());
        user.setSupplierControlPanel(request.isSupplierControlPanel());
        user.setUserControlPanel(request.isUserControlPanel());
        user.setCustomerApproval(request.isCustomerApproval());
        user.setOrderApproval(request.isOrderApproval());
        user.setReports(request.isReports());
        user.setMobileApp(request.isMobileApp());

        userRepository.updateObject(user);
        return user.getIndexNo();
    }

    @Override
    public MUser getUser(Serializable indexNo) {
        return (MUser) userRepository.getObject(MUser.class, indexNo);
    }

    @Override
    public Boolean toggleActivationUser(Serializable indexNo) {
        MUser user = (MUser) userRepository.getObject(MUser.class, indexNo);

        user.setActive(!user.isActive());
        userRepository.updateObject(user);

        return user.isActive();
    }

    @Override
    public Boolean deleteUser(Serializable indexNo) {
        try {
            MUser user = (MUser) userRepository.getObject(MUser.class, indexNo);

            userRepository.deleteObject(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
