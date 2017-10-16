package com.tr.sigorta.web.controller;

import com.tr.sigorta.dao.AgencyUserDao;
import com.tr.sigorta.domain.Agency;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mustafa Erbin on 12/10/2017.
 */
@RestController
@RequestMapping(value = "agency-user")
public class AgencyUserController {

    @Autowired
    AgencyUserDao agencyUserDao;

    @GetMapping
    public List<AgencyUser> findAll() {
        return agencyUserDao.findAll();
    }

    @PostMapping
    public AgencyUser create(@RequestBody AgencyUser agencyUser) {
        return agencyUserDao.create(agencyUser);
    }

    @PutMapping
    public AgencyUser update(@RequestBody AgencyUser agencyUser) {
        return agencyUserDao.update(agencyUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public void delete(@PathVariable("oid") Long id) {
        agencyUserDao.delete(id);
    }

}
