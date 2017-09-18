package com.sv.orderapp.supplier_control_panel;

import com.sv.orderapp.supplier_control_panel.model.MRoute;
import com.sv.orderapp.supplier_control_panel.request.NewTransactorRequest;
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
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/supplier-form/new")
    public ModelAndView attemtSupplierform() {
        ModelAndView modelAndView = new ModelAndView("supplier-control-panel/supplier-form");

        modelAndView.addObject("action", "new");

        return modelAndView;
    }

    @RequestMapping("/supplier-form/{action}/{indexNo}")
    public ModelAndView attemtSupplierform(
            @PathVariable String action,
            @PathVariable Integer indexNo) {
        ModelAndView modelAndView = new ModelAndView("supplier-control-panel/supplier-form");

        modelAndView.addObject("action", action);
        modelAndView.addObject("transactor", supplierService.gerTransactor(indexNo));

        return modelAndView;
    }

    @RequestMapping("/supplier-list")
    public ModelAndView attemtSupplierList() {
        ModelAndView modelAndView = new ModelAndView("supplier-control-panel/supplier-list");

        modelAndView.addObject("transactors", supplierService.listTransactors());

        return modelAndView;
    }

    @RequestMapping("/rest/new-supplier")
    public @ResponseBody
    Integer newTransactor(@RequestBody NewTransactorRequest transactorRequest) {
        return (Integer) supplierService.newTransactor(transactorRequest);
    }

    @RequestMapping("/rest/update-supplier")
    public @ResponseBody
    Integer updateTransactor(@RequestBody NewTransactorRequest transactorRequest) {
        return (Integer) supplierService.updateTransactor(transactorRequest);
    }

    @RequestMapping("/rest/toggle-activation-supplier/{indexNo}")
    public @ResponseBody
    Boolean toggleActivation(@PathVariable Integer indexNo) {
        return supplierService.toggleActivationTransactor(indexNo);
    }

    @RequestMapping("/rest/delete-supplier/{indexNo}")
    public @ResponseBody
    Boolean deleteItem(@PathVariable Integer indexNo) {
        return supplierService.deleteTransactor(indexNo);
    }
}
