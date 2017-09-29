package com.tr.sigorta.web.controller;

import com.tr.sigorta.dao.CompanyUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@RestController
@RequestMapping(value = "company-user")
public class CompanyUserController {

    @Autowired
    CompanyUserDao companyUserDao;
}
