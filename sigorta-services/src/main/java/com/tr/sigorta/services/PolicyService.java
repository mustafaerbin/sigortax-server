package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.PolicyDao;
import com.tr.sigorta.dao.PolicyOldDao;
import com.tr.sigorta.domain.*;
import com.tr.sigorta.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Erbin on 29/09/2017.
 */
@Service
public class PolicyService extends JpaService<Policy, Long> {

    @Autowired
    PolicyDao policyDao;

    @Autowired
    PolicyOldDao policyOldDao;

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
                return policyDao.findAllAgentyAdmin(agencyUser);
            }
            case "AGENCY_ADMIN": {
                return policyDao.findAllAgentyAdmin(agencyUser);
            }
            default:
                return (List<Policy>) policyDao.findAll();
        }
    }


    /**
     * Bitiş tarihi geçmiş poliçeleri listeler
     *
     * @return poliçe listesi
     */
    public List<Policy> listPolicyOld(Date today) {
        return policyDao.listPolicyOld(today);
    }

    /**
     * Hatırlatma tarihi gelmiş poliçeleri listeler.
     *
     * @return poliçe listesi
     */
    public List<Policy> listPolicyReminderDate(Date today) {
        return policyDao.listPolicyReminderDate(today);
    }

    public PolicyOld oldPolicy(Policy policy) {
        PolicyOld policyOld = policyOldDao.getNew();
        policyOld.setId(policy.getId());
        policyOld.setAgencyUser(policy.getAgencyUser());
        policyOld.setAgencyId(policy.getAgencyId());
        policyOld.setCompany(policy.getCompany().getName());
        policyOld.setCompanyProduct(policy.getCompanyProduct().getName());
        policyOld.setCompanySubProduct(policy.getCompanySubProduct().getName());
        policyOld.setCustomer(policy.getCustomerFullName());
        policyOld.setCustomerMessage(policy.getCustomerMessage());
        policyOld.setDescription(policy.getDescription());
        policyOld.setEndDate(policy.getEndDate());
        policyOld.setStartDate(policy.getStartDate());
        policyOld.setPolicyEmount(policy.getPolicyEmount());
        policyOld.setPolicyNumber(policy.getPolicyNumber());
        policyOld.setReminderDate(policy.getReminderDate());
        return policyOld;
    }
}
