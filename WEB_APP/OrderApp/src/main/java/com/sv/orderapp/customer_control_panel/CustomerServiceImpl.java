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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohan
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<MRoute> listRoutes() {
        return customerRepository.listObjects(MRoute.class);
    }

    @Override
    public List<MTransactor> listTransactors() {
        return customerRepository.listTransactors();
    }

    @Override
    public List<MTransactor> listPendingTransactors() {
        return customerRepository.listPendingTransactors();
    }

    @Override
    public Integer newRoute(String name) {
        MRoute route = new MRoute();
        route.setName(name);
        route.setVersion(1);

        return (Integer) customerRepository.newObject(route);
    }

    @Override
    public Serializable newTransactor(NewTransactorRequest request) {
        MRoute route = (MRoute) customerRepository.getObject(MRoute.class, request.getRoute());

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
        transactor.setMRoute(route);
        transactor.setCreditLimit(request.getCreditLimit());
        transactor.setCreditAmount(request.getCreditAmount());
        transactor.setClient(true);
        transactor.setSupplier(false);
        transactor.setApproved(false);
        transactor.setActive(true);
        transactor.setVersion(1);

        return customerRepository.newObject(transactor);
    }

    @Override
    public Serializable updateTransactor(NewTransactorRequest request) {
        MRoute route = (MRoute) customerRepository.getObject(MRoute.class, request.getRoute());

        MTransactor transactor = (MTransactor) customerRepository.getObject(MTransactor.class, request.getIndexNo());

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
        transactor.setMRoute(route);
        transactor.setCreditLimit(request.getCreditLimit());
        transactor.setCreditAmount(request.getCreditAmount());
        transactor.setClient(true);
        transactor.setSupplier(false);
        transactor.setApproved(false);
        transactor.setActive(true);
        transactor.setVersion(transactor.getVersion()+1);

        customerRepository.updateObject(transactor);

        return transactor.getIndexNo();
    }

    @Override
    public MTransactor gerTransactor(Serializable indexNo) {
        return (MTransactor) customerRepository.getObject(MTransactor.class, indexNo);
    }

    @Override
    public Boolean toggleActivationTransactor(Serializable indexNo) {
        MTransactor transactor = (MTransactor) customerRepository.getObject(MTransactor.class, indexNo);

        transactor.setActive(!transactor.isActive());
        customerRepository.updateObject(transactor);

        return transactor.isActive();
    }

    @Override
    public Boolean toggleApprovalTransactor(Serializable indexNo) {
        MTransactor transactor = (MTransactor) customerRepository.getObject(MTransactor.class, indexNo);

        transactor.setApproved(!transactor.isApproved());
        customerRepository.updateObject(transactor);

        return transactor.isApproved();
    }

    @Override
    public Boolean deleteTransactor(Serializable indexNo) {
        try {
            MTransactor transactor = (MTransactor) customerRepository.getObject(MTransactor.class, indexNo);

            customerRepository.deleteObject(transactor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
