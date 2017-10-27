package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.domain.Policy;
import com.tr.sigorta.services.PolicyService;
import com.tr.sigorta.web.jobs.AgencyMailJob;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public Policy delete(@PathVariable("oid") Long id) {
        return policyService.delete(id);
    }

    @GetMapping(value = "mail")
    public void sentMail() {
        agencyMailJob.sendMail("Selam" + "</br></br>" + " Poliçe Sistem Numarası : " + 3, "mustafaerbin@hotmail.com");
    }
}
