/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.orderapp.supplier_control_panel;

import com.sv.orderapp.supplier_control_panel.model.MRoute;
import com.sv.orderapp.supplier_control_panel.model.MTransactor;
import com.sv.orderapp.supplier_control_panel.request.NewTransactorRequest;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mohan
 */
public interface SupplierService {

    public List<MRoute> listRoutes();

    public List<MTransactor> listTransactors();

    public List<MTransactor> listPendingTransactors();

    public Integer newRoute(String name);

    public Serializable newTransactor(NewTransactorRequest request);

    public Serializable updateTransactor(NewTransactorRequest request);

    public MTransactor gerTransactor(Serializable code);

    public Boolean toggleActivationTransactor(Serializable code);

    public Boolean deleteTransactor(Serializable code);

}
