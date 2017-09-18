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

/**
 *
 * @author Mohan
 */
public interface UserService {

    public List<MUser> listUsers();

    public Serializable newUser(NewUserRequest request);

    public Serializable updateUser(NewUserRequest request);

    public MUser getUser(Serializable indexNo);

    public Boolean toggleActivationUser(Serializable indexNo);

    public Boolean deleteUser(Serializable indexNo);
}
