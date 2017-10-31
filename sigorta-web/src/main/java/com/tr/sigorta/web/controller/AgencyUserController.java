package com.tr.sigorta.web.controller;

import com.tr.nebula.security.api.model.SessionUser;
import com.tr.sigorta.dao.AgencyUserDao;
import com.tr.sigorta.domain.Agency;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.services.DateService;
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

    @Autowired
    DateService dateService;

    @GetMapping
    public List<AgencyUser> findAll() {
        return agencyUserDao.findAll();
    }

    @GetMapping(value = "{id}")
    public AgencyUser findById(@PathVariable("id") Long id) {
        return agencyUserDao.findById(id);
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

    /**
     * Kullanıcının kullanım süresini kontrol eder.
     *
     * @param id
     * @return
     */
    @GetMapping(value = "check/{id}")
    public Boolean checkUser(@PathVariable("id") Long id) {
        AgencyUser agencyUser = agencyUserDao.findById(id);
        if (agencyUser.getEndDate() != null &&
                agencyUser.getEndDate().getTime() < dateService.getToday().getTime()) {
            return false;
        } else
            return true;
    }

    @GetMapping(value = "agencyUser")
    public AgencyUser getAgencyUser(SessionUser sessionUser) {
        return (AgencyUser) sessionUser.getUser();
    }

}
