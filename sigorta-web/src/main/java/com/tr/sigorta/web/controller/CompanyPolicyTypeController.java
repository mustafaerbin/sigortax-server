package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.domain.CompanyPolicyType;
import com.tr.sigorta.domain.CompanySubProduct;
import com.tr.sigorta.services.CompanyPolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 16/10/2017.
 */
@RestController
@RequestMapping(value = "company-policy-type")
public class CompanyPolicyTypeController {

    @Autowired
    CompanyPolicyTypeService companyPolicyTypeService;

    @GetMapping
    public List<CompanyPolicyType> findAll() {
        return companyPolicyTypeService.findAll();
    }

    @PostMapping
    public CompanyPolicyType create(SessionUser sessionUser, @RequestBody CompanyPolicyType company) {
        return companyPolicyTypeService.create(company);
    }

    @PutMapping
    public CompanyPolicyType update(SessionUser sessionUser, @RequestBody CompanyPolicyType companyPolicyType) {
        return companyPolicyTypeService.update(companyPolicyType, companyPolicyType.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public CompanyPolicyType delete(@PathVariable("oid") Long id) {
        return companyPolicyTypeService.delete(id);
    }


}
