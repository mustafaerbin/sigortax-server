package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.CustomerDao;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.domain.Policy;
import com.tr.sigorta.domain.enumm.EnumCustomerType;
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
        switch (agencyUser.getRole().getCode()) {
            case "AGENCY_USER": {
                return customerDao.findAllAgentyAdmin(agencyUser);
            }
            case "AGENCY_ADMIN": {
                return customerDao.findAllAgentyAdmin(agencyUser);
            }
            default:
                return (List<Customer>) customerDao.findAll();
        }
    }

    public List<Customer> listCustomerWityType(EnumCustomerType enumCustomerType, SessionUser sessionUser) {
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        switch (agencyUser.getRole().getCode()) {
            case "AGENCY_USER": {
                return customerDao.listCustomerWityType(agencyUser,enumCustomerType);
            }
            case "AGENCY_ADMIN": {
                return customerDao.listCustomerWityType(agencyUser,enumCustomerType);
            }
            default:
                return (List<Customer>) customerDao.findAll();
        }
    }

    public Customer create(SessionUser sessionUser, Customer customer) {
        Customer customer1 = customer;
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        customer1.setAgencyUser(agencyUser);
        customer1.setAgencyId(agencyUser.getAgency().getId());
        return customerDao.create(customer1);
    }

    public Customer update(SessionUser sessionUser, Customer customer) {
        Customer customer1 = customer;
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        customer1.setAgencyUser(agencyUser);
        customer1.setAgencyId(agencyUser.getAgency().getId());
        return customerDao.update(customer1);
    }
}
