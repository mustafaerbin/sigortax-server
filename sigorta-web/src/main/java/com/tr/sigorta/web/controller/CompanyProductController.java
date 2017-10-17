package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.services.CompanyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 16/10/2017.
 */
@RestController
@RequestMapping(value = "company-product")
public class CompanyProductController {

    @Autowired
    CompanyProductService companyProductService;

    @GetMapping
    public List<CompanyProduct> findAll() {
        return companyProductService.findAll();
    }

    @PostMapping
    public CompanyProduct create(SessionUser sessionUser, @RequestBody CompanyProduct companyProduct) {
        return companyProductService.create(companyProduct);
    }

    @PutMapping
    public CompanyProduct update(SessionUser sessionUser, @RequestBody CompanyProduct companyProduct) {
        return companyProductService.update(companyProduct, companyProduct.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public CompanyProduct delete(@PathVariable("oid") Long id) {
        return companyProductService.delete(id);
    }


}
