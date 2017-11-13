package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.domain.enumm.EnumCustomerType;
import com.tr.sigorta.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@RestController
@RequestMapping(value = "customer")
@Transactional
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll(SessionUser sessionUser) {
        return customerService.findAll(sessionUser);
    }

    @GetMapping(value = "type/{type}")
    public List<Customer> listCustomerWityType(@PathVariable("type") EnumCustomerType enumCustomerType, SessionUser sessionUser) {
        return customerService.listCustomerWityType(enumCustomerType, sessionUser);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer create(SessionUser sessionUser, @RequestBody Customer customer) {
        return customerService.create(sessionUser, customer);
    }

    @PutMapping
    public Customer update(SessionUser sessionUser, @RequestBody Customer customer) {
        return customerService.update(sessionUser, customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public Customer delete(@PathVariable("oid") Long id) {
        return customerService.delete(id);
    }

}
