package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanySubProduct;
import com.tr.sigorta.services.CompanySubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 16/10/2017.
 */
@RestController
@RequestMapping(value = "company-sub-product")
public class CompanySubProductController {

    @Autowired
    CompanySubProductService companySubProductService;

    @GetMapping
    public List<CompanySubProduct> findAll() {
        return companySubProductService.findAll();
    }

    @PostMapping
    public CompanySubProduct create(SessionUser sessionUser, @RequestBody CompanySubProduct company) {
        return companySubProductService.create(company);
    }

    @PutMapping
    public CompanySubProduct update(SessionUser sessionUser, @RequestBody CompanySubProduct company) {
        return companySubProductService.update(company, company.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public CompanySubProduct delete(@PathVariable("oid") Long id) {
        return companySubProductService.delete(id);
    }


}
