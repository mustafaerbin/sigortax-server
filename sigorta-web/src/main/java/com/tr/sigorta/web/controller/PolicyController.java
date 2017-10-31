package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.PolicyOldDao;
import com.tr.sigorta.domain.Policy;
import com.tr.sigorta.domain.PolicyOld;
import com.tr.sigorta.domain.enumm.EnumPolicyState;
import com.tr.sigorta.services.PolicyService;
import com.tr.sigorta.web.jobs.AgencyMailJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@RestController
@RequestMapping(value = "policy")
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @Autowired
    AgencyMailJob agencyMailJob;

    @Autowired
    PolicyOldDao policyOldDao;

    @GetMapping
    public List<Policy> findAll(SessionUser sessionUser) {
        return policyService.findAll(sessionUser);
    }

    @PostMapping
    public Policy create(SessionUser sessionUser, @RequestBody Policy policy) {
        return policyService.create(sessionUser, policy);
    }

    @PutMapping
    public Policy update(SessionUser sessionUser, @RequestBody Policy policy) {
        return policyService.update(policy, policy.getId());
    }

    @GetMapping(value = "{oid}")
    public Policy delete(@PathVariable("oid") Long id) {
        Policy policy = policyService.findOne(id);
        PolicyOld policyOld = policyService.oldPolicy(policy);
        policyOldDao.create(policyOld);
        return policyService.delete(id);
    }

    @PostMapping(value = "{oldId}")
    @Transactional
    public Policy refresh(SessionUser sessionUser, @PathVariable("oldId") Long oldId, @RequestBody Policy policy) {
        Policy oldPolicy = policyService.findOne(oldId);
        oldPolicy.setEnumPolicyState(EnumPolicyState.YENILENDI);
        policyService.update(oldPolicy, oldPolicy.getId());
        return policyService.create(sessionUser, policy);

    }

    @GetMapping(value = "mail")
    public void sentMail() {
        //agencyMailJob.sendMail("Selam" + "</br></br>" + " Poliçe Sistem Numarası : " + 3, "mustafaerbin@hotmail.com");
    }
}
