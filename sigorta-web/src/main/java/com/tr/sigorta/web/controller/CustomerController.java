package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.CustomerDao;
import com.tr.sigorta.domain.CompanyUser;
import com.tr.sigorta.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@RestController
@RequestMapping(value = "customer")
@Transactional
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll(SessionUser sessionUser) {
        CompanyUser companyUser = (CompanyUser) sessionUser.getUser();
        List<Customer> findAll = customerDao.findAll();
        List<Customer> findAllUser = customerDao.findAll(companyUser);
        return findAll;
    }

}
