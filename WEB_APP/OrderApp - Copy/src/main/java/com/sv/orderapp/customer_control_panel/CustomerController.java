package com.sv.orderapp.customer_control_panel;

import com.sv.orderapp.customer_control_panel.model.MRoute;
import com.sv.orderapp.customer_control_panel.request.NewTransactorRequest;
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
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer-form/new")
    public ModelAndView attemtCustomerform() {
        ModelAndView modelAndView = new ModelAndView("customer-control-panel/customer-form");

        modelAndView.addObject("action", "new");

        return modelAndView;
    }

    @RequestMapping("/customer-form/{action}/{indexNo}")
    public ModelAndView attemtCustomerform(
            @PathVariable String action,
            @PathVariable Integer indexNo) {
        ModelAndView modelAndView = new ModelAndView("customer-control-panel/customer-form");

        modelAndView.addObject("action", action);
        modelAndView.addObject("transactor", customerService.gerTransactor(indexNo));

        return modelAndView;
    }

    @RequestMapping("/customer-list")
    public ModelAndView attemtCustomerList() {
        ModelAndView modelAndView = new ModelAndView("customer-control-panel/customer-list");

        modelAndView.addObject("transactors", customerService.listTransactors());

        return modelAndView;
    }

    @RequestMapping("/customer-approval")
    public ModelAndView attemtCustomerApproval() {
        ModelAndView modelAndView = new ModelAndView("customer-control-panel/customer-approval");

        modelAndView.addObject("transactors", customerService.listPendingTransactors());

        return modelAndView;
    }

    @RequestMapping("/rest/list-route")
    public @ResponseBody
    List<MRoute> listRoute() {
        return customerService.listRoutes();
    }

    @RequestMapping("/rest/new-route/{name}")
    public @ResponseBody
    Integer newRoute(@PathVariable String name) {
        return customerService.newRoute(name);
    }

    @RequestMapping("/rest/new-customer")
    public @ResponseBody
    Integer newTransactor(@RequestBody NewTransactorRequest transactorRequest) {
        return (Integer) customerService.newTransactor(transactorRequest);
    }

    @RequestMapping("/rest/update-customer")
    public @ResponseBody
    Integer updateTransactor(@RequestBody NewTransactorRequest transactorRequest) {
        return (Integer) customerService.updateTransactor(transactorRequest);
    }

    @RequestMapping("/rest/toggle-activation-customer/{indexNo}")
    public @ResponseBody
    Boolean toggleActivation(@PathVariable Integer indexNo) {
        return customerService.toggleActivationTransactor(indexNo);
    }

    @RequestMapping("/rest/toggle-approval-customer/{indexNo}")
    public @ResponseBody
    Boolean toggleApproval(@PathVariable Integer indexNo) {
        return customerService.toggleApprovalTransactor(indexNo);
    }

    @RequestMapping("/rest/delete-customer/{indexNo}")
    public @ResponseBody
    Boolean deleteItem(@PathVariable Integer indexNo) {
        return customerService.deleteTransactor(indexNo);
    }
}
