package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.domain.Policy;
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
     * @param agencyUser login olan kullanıcısı
     * @return kullanıcı listesi
     */
    public List<Customer> findAll(AgencyUser agencyUser) {
        List<Customer> resultList = null;
        try {
            Query query = entityManager.createQuery("from Customer o where o.agencyUser=:agencyUser")
                    .setParameter("agencyUser", agencyUser);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * tüm müşteriler, acente admini için
     *
     * @param agencyUser login olan kullanıcısı
     * @return poliçe listesi
     */
    public List<Customer> findAllAgentyAdmin(AgencyUser agencyUser) {
        Long agencyId = agencyUser.getAgency().getId();
        List<Customer> resultList = null;
        try {
            Query query = entityManager.createQuery("from Customer o where o.agencyId=:agencyId")
                    .setParameter("agencyId", agencyId);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
