package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.sigorta.dao.CompanyDao;
import com.tr.sigorta.dao.CompanyProductDao;
import com.tr.sigorta.dao.CompanySubProductDao;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.domain.CompanySubProduct;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.repository.CompanyRepository;
import com.tr.sigorta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    private CompanySubProductDao companySubProductDao;

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

    public List<CompanySubProduct> listCompanySubProduct(Company companyProduct) {
        return companySubProductDao.listCompanySubProduct(companyProduct);
    }
}
