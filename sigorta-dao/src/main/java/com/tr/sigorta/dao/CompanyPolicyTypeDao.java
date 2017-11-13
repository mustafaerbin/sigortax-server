package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyPolicyType;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.domain.CompanySubProduct;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 30/09/2017.
 */
@Service
public class CompanyPolicyTypeDao extends BaseDaoImpl<CompanyPolicyType, Long> {

    public CompanyPolicyType getNew() {
        return new CompanyPolicyType();
    }

    public List<CompanyPolicyType> listCompanyPolicyType(Company company) {
        List<CompanyPolicyType> resultList = null;
        try {
            Query query = entityManager.createQuery("from CompanyPolicyType o where o.company=:company order by name asc")
                    .setParameter("company", company);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
