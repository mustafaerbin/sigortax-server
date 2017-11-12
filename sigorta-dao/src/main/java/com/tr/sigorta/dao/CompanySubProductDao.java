package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.domain.CompanySubProduct;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 30/09/2017.
 */
@Service
public class CompanySubProductDao extends BaseDaoImpl<CompanySubProduct, Long> {

    public CompanySubProduct getNew() {
        return new CompanySubProduct();
    }

    public List<CompanySubProduct> listCompanySubProduct(Company companyProduct) {
        List<CompanySubProduct> resultList = null;
        try {
            Query query = entityManager.createQuery("from CompanySubProduct o where o.company=:companyProduct")
                    .setParameter("companyProduct", companyProduct);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
