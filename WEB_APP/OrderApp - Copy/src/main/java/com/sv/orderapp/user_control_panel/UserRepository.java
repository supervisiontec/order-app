/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.user_control_panel;

import com.sv.orderapp.user_control_panel.model.MUser;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mohan
 */
public interface UserRepository {

    public List<MUser> listUsers();

    public List listObjects(Class cls);

    public Object getObject(Class cls, Serializable id);

    public Serializable newObject(Object object);

    public void updateObject(Object object);

    public void deleteObject(Object object);
}
