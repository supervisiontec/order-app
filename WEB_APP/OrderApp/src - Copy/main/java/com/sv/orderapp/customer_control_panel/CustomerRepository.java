/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.customer_control_panel;

import com.sv.orderapp.customer_control_panel.model.MTransactor;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mohan
 */
public interface CustomerRepository {

    public List<MTransactor> listTransactors();

    public List<MTransactor> listPendingTransactors();

    public List listObjects(Class cls);

    public Object getObject(Class cls, Serializable id);

    public Serializable newObject(Object object);

    public void updateObject(Object object);

    public void deleteObject(Object object);
}
