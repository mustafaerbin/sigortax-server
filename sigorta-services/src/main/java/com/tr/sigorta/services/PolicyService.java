package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.PolicyDao;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.domain.Policy;
import com.tr.sigorta.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 29/09/2017.
 */
@Service
public class PolicyService extends JpaService<Policy, Long> {

    @Autowired
    PolicyDao policyDao;

    @Autowired
    public PolicyService(PolicyRepository repository) {
        super(repository);
    }

    public Policy create(SessionUser sessionUser, @RequestBody Policy response) {
        Policy policy = response;
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        policy.setAgencyUser(agencyUser);
        return policyDao.create(policy);
    }

    public List<Policy> findAll(SessionUser sessionUser) {
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        switch (agencyUser.getRole().getCode()) {
            case "AGENCY_USER": {
                return policyDao.findAll(agencyUser);
            }
            case "AGENCY_ADMIN": {
                return policyDao.findAllAgentyAdmin(agencyUser);
            }
            default:
                return policyDao.findAll(agencyUser);
        }
    }


}
