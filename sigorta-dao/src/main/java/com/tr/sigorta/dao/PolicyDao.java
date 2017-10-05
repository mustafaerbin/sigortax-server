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
public class PolicyDao extends BaseDaoImpl<Policy, Long> {

    public Policy getNew() {
        return new Policy();
    }

    /**
     * Kullanıcının kaydettiği poliçeleri listesi.
     *
     * @param agencyUser login olan kullanıcısı
     * @return poliçe listesi
     */
    public List<Policy> findAll(AgencyUser agencyUser) {
        List<Policy> resultList = null;
        try {
            Query query = entityManager.createQuery("from Policy o where o.agencyUser=:agencyUser")
                    .setParameter("agencyUser", agencyUser);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Kullanıcının kaydettiği poliçeleri listesi. acente kullanıcılarının kaydettiği poliçeler, acente admini için
     *
     * @param agencyUser login olan kullanıcısı
     * @return poliçe listesi
     */
    public List<Policy> findAllAgentyAdmin(AgencyUser agencyUser) {
        Long agencyId = agencyUser.getAgency().getId();
        List<Policy> resultList = null;
        try {
            Query query = entityManager.createQuery("from Policy o where o.agencyId=:agencyId")
                    .setParameter("agencyId", agencyId);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
