/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.customer_control_panel;

import com.sv.orderapp.customer_control_panel.model.MRoute;
import com.sv.orderapp.customer_control_panel.model.MTransactor;
import com.sv.orderapp.customer_control_panel.request.NewTransactorRequest;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mohan
 */
public interface CustomerService {

    public List<MRoute> listRoutes();

    public List<MTransactor> listTransactors();
    
    public List<MTransactor> listPendingTransactors();

    public Integer newRoute(String name);

    public Serializable newTransactor(NewTransactorRequest request);

    public Serializable updateTransactor(NewTransactorRequest request);

    public MTransactor gerTransactor(Serializable indexNo);

    public Boolean toggleActivationTransactor(Serializable indexNo);
    
    public Boolean toggleApprovalTransactor(Serializable indexNo);

    public Boolean deleteTransactor(Serializable indexNo);

}
