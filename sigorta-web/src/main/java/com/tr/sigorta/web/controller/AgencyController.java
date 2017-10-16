package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.nebula.security.core.annotation.Auth;
import com.tr.nebula.security.core.annotation.PermissionGroup;
import com.tr.sigorta.dao.AgencyDao;
import com.tr.sigorta.domain.Agency;
import com.tr.sigorta.domain.Company;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 12/10/2017.
 */
@RestController
@RequestMapping(value = "agency")
public class AgencyController {

    @Autowired
    AgencyDao agencyDao;

    @GetMapping
    public List<Agency> findAll() {
        return agencyDao.findAll();
    }

    @PostMapping
    public Agency create(@RequestBody Agency agency) {
        return agencyDao.create(agency);
    }

    @PutMapping
    public Agency update(@RequestBody Agency agency) {
        return agencyDao.update(agency);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public void delete(@PathVariable("oid") Long id) {
        agencyDao.delete(id);
    }

}
