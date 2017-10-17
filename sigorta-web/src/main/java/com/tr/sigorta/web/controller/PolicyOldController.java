package com.tr.sigorta.web.controller;


import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.PolicyOldDao;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Policy;
import com.tr.sigorta.domain.PolicyOld;
import com.tr.sigorta.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 17/10/2017.
 */
@RestController
@RequestMapping(value = "policy-old")
public class PolicyOldController {

    @Autowired
    PolicyOldDao policyOldDao;

    @GetMapping
    public List<PolicyOld> findAll(SessionUser sessionUser) {
        AgencyUser agencyUser = (AgencyUser) sessionUser.getUser();
        switch (agencyUser.getRole().getCode()) {
            case "AGENCY_USER": {
                return policyOldDao.findAll(agencyUser);
            }
            case "AGENCY_ADMIN": {
                return policyOldDao.findAllAgentyAdmin(agencyUser);
            }
            default:
                return policyOldDao.findAll();
        }
    }

}
