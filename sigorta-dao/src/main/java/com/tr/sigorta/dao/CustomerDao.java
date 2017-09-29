package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.CompanyUser;
import com.tr.sigorta.domain.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@Service
public class CustomerDao extends BaseDaoImpl<Customer, Long> {

    /**
     * Kullanıcıya kayıtlı müşterileri listesi.
     *
     * @param companyUser login olan kullanıcısı
     * @return kullanıcı listesi
     */
    public List<Customer> findAll(CompanyUser companyUser) {
        List<Customer> resultList = null;
        try {
            Query query = entityManager.createQuery("from Customer o where o.companyUser=:companyUser")
                    .setParameter("companyUser", companyUser);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

}
