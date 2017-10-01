package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.domain.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@Service
public class CompanyProductDao extends BaseDaoImpl<CompanyProduct, Long> {

    public CompanyProduct getNew() {
        return new CompanyProduct();
    }

    public List<CompanyProduct> listCompanyProduct(Company company) {

        List<CompanyProduct> resultList = null;
        try {
            Query query = entityManager.createQuery("from CompanyProduct o where o.company=:company")
                    .setParameter("company", company);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
