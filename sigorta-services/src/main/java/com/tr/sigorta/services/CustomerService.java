package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.CustomerDao;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Mustafa Erbin on 29/09/2017.
 */
@Service
public class CustomerService extends JpaService<Customer, Long> {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        super(repository);
    }

    public List<Customer> findAll(SessionUser sessionUser) {
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        return customerDao.findAll(agencyUser);
    }

    public Customer create(SessionUser sessionUser, @RequestBody Customer customer) {
        Customer customer1 = customer;
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        customer1.setAgencyUser(agencyUser);
        return customerDao.create(customer1);
    }

    public Customer update(SessionUser sessionUser, @RequestBody Customer customer) {
        Customer customer1 = customer;
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        customer1.setAgencyUser(agencyUser);
        return customerDao.update(customer1);
    }
}
