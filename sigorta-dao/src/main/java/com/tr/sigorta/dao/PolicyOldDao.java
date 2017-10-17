package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.PolicyOld;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 17/10/2017.
 * Eski poliçe işlemleri.
 */
@Service
public class PolicyOldDao extends BaseDaoImpl<PolicyOld, Long> {

    public PolicyOld getNew() {
        return new PolicyOld();
    }


    /**
     * Kullanıcının kaydettiği poliçeleri listesi.
     *
     * @param agencyUser login olan kullanıcısı
     * @return poliçe listesi
     */
    public List<PolicyOld> findAll(AgencyUser agencyUser) {
        List<PolicyOld> resultList = null;
        try {
            Query query = entityManager.createQuery("from PolicyOld o where o.agencyUser=:agencyUser")
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
    public List<PolicyOld> findAllAgentyAdmin(AgencyUser agencyUser) {
        Long agencyId = agencyUser.getAgency().getId();
        List<PolicyOld> resultList = null;
        try {
            Query query = entityManager.createQuery("from PolicyOld o where o.agencyId=:agencyId")
                    .setParameter("agencyId", agencyId);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
