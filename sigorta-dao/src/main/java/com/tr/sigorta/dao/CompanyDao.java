package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.Agency;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@Service
public class CompanyDao extends BaseDaoImpl<Company, Long> {

    public Company getNew() {
        return new Company();
    }

    public List<Company> findAllStatusTrue() {
        List<Company> resultList = null;
        try {
            Query query = entityManager.createQuery("from Company o where o.status=1 order by name asc");
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
