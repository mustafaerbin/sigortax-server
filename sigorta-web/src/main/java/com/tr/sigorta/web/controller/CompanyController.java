package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.domain.CompanySubProduct;
import com.tr.sigorta.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@RestController
@RequestMapping(value = "company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/all")
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping
    public List<Company> findAllStatusTrue() {
        return companyService.findAllStatusTrue();
    }

    @PostMapping
    public Company create(SessionUser sessionUser, @RequestBody Company company) {
        return companyService.create(company);
    }

    @PutMapping
    public Company update(SessionUser sessionUser, @RequestBody Company company) {
        return companyService.update(company, company.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public Company delete(@PathVariable("oid") Long id) {
        return companyService.delete(id);
    }

    @PostMapping(value = "/list-company-product")
    public List<CompanyProduct> listCompanyProduct(@RequestBody Company company) {
        return companyService.listCompanyProduct(company);
    }

    @PostMapping(value = "/list-company-sub-product")
    public List<CompanySubProduct> listCompanySubProduct(@RequestBody CompanyProduct companyProduct) {
        return companyService.listCompanySubProduct(companyProduct);
    }

}
