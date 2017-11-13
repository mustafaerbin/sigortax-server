package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.sigorta.dao.CompanyDao;
import com.tr.sigorta.dao.CompanyProductDao;
import com.tr.sigorta.dao.CompanyPolicyTypeDao;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyPolicyType;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.domain.CompanySubProduct;
import com.tr.sigorta.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mustafa Erbin on 29/09/2017.
 */
@Service
public class CompanyService extends JpaService<Company, Long> {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private CompanyProductDao companyProductDao;

    @Autowired
    private CompanyPolicyTypeDao companySubProductDao;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        super(repository);
    }

    public List<Company> findAllStatusTrue() {
        return companyDao.findAllStatusTrue();
    }

    public List<CompanyProduct> listCompanyProduct(Company company) {
        return companyProductDao.listCompanyProduct(company);
    }

    public List<CompanyPolicyType> listCompanyPolicyType(Company company) {
        return companySubProductDao.listCompanyPolicyType(company);
    }
}
