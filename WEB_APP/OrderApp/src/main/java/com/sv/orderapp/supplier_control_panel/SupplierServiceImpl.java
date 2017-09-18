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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohan
 */
@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<MRoute> listRoutes() {
        return supplierRepository.listObjects(MRoute.class);
    }

    @Override
    public List<MTransactor> listTransactors() {
        return supplierRepository.listTransactors();
    }

    @Override
    public List<MTransactor> listPendingTransactors() {
        return supplierRepository.listPendingTransactors();
    }

    @Override
    public Integer newRoute(String name) {
        MRoute route = new MRoute();
        route.setName(name);

        return (Integer) supplierRepository.newObject(route);
    }

    @Override
    public Serializable newTransactor(NewTransactorRequest request) {
//        MRoute route = (MRoute) supplierRepository.getObject(MRoute.class, request.getRoute());

        MTransactor transactor = new MTransactor();

        transactor.setName(request.getName());
        transactor.setContactPerson(request.getContactPerson());
        transactor.setMobile(request.getMobile());
        transactor.setTelephone1(request.getTelephone1());
        transactor.setTelephone2(request.getTelephone2());
        transactor.setAddressLine1(request.getAddressLine1());
        transactor.setAddressLine2(request.getAddressLine2());
        transactor.setAddressLine3(request.getAddressLine3());
        transactor.setFax(request.getFax());
        transactor.setEmail(request.getEmail());
        transactor.setMRoute(null);
        transactor.setCreditLimit(request.getCreditLimit());
        transactor.setCreditAmount(request.getCreditAmount());
        transactor.setClient(false);
        transactor.setSupplier(true);
        transactor.setApproved(true);
        transactor.setActive(true);
        transactor.setVersion(1);

        return supplierRepository.newObject(transactor);
    }

    @Override
    public Serializable updateTransactor(NewTransactorRequest request) {
//        MRoute route = (MRoute) supplierRepository.getObject(MRoute.class, request.getRoute());

        MTransactor transactor = (MTransactor) supplierRepository.getObject(MTransactor.class, request.getIndexNo());

        transactor.setName(request.getName());
        transactor.setContactPerson(request.getContactPerson());
        transactor.setMobile(request.getMobile());
        transactor.setTelephone1(request.getTelephone1());
        transactor.setTelephone2(request.getTelephone2());
        transactor.setAddressLine1(request.getAddressLine1());
        transactor.setAddressLine2(request.getAddressLine2());
        transactor.setAddressLine3(request.getAddressLine3());
        transactor.setFax(request.getFax());
        transactor.setEmail(request.getEmail());
        transactor.setMRoute(null);
        transactor.setCreditLimit(request.getCreditLimit());
        transactor.setCreditAmount(request.getCreditAmount());
        transactor.setClient(false);
        transactor.setSupplier(true);
        transactor.setApproved(false);
        transactor.setActive(true);
        transactor.setVersion(transactor.getVersion()+1);

        supplierRepository.updateObject(transactor);

        return transactor.getIndexNo();
    }

    @Override
    public MTransactor gerTransactor(Serializable indexNo) {
        return (MTransactor) supplierRepository.getObject(MTransactor.class, indexNo);
    }

    @Override
    public Boolean toggleActivationTransactor(Serializable indexNo) {
        MTransactor transactor = (MTransactor) supplierRepository.getObject(MTransactor.class, indexNo);

        transactor.setActive(!transactor.isActive());
        supplierRepository.updateObject(transactor);

        return transactor.isActive();
    }

    @Override
    public Boolean deleteTransactor(Serializable indexNo) {
        try {
            MTransactor transactor = (MTransactor) supplierRepository.getObject(MTransactor.class, indexNo);

            supplierRepository.deleteObject(transactor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
