package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.domain.Policy;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.Date;
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
            Query query = entityManager.createQuery("from Policy o where o.agencyId=:agencyId order by o.createDate desc")
                    .setParameter("agencyId", agencyId);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Kullanıcının kaydettiği poliçeleri listesi. acente kullanıcılarının kaydettiği poliçeler, acente admini için
     *
     * @return poliçe listesi
     */
    public List<Policy> findAllSuperAdmin() {
        List<Policy> resultList = null;
        try {
            Query query = entityManager.createQuery("from Policy o order by o.createDate desc");
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Bitiş tarihi geçmiş poliçeleri listeler
     *
     * @return poliçe listesi
     */
    public List<Policy> listPolicyOld(Date today) {
        List<Policy> resultList = null;
        try {
            Query query = entityManager.createQuery("from Policy o where o.endDate< :today")
                    .setParameter("today", today);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Hatırlatma tarihi gelmiş poliçeleri listeler.
     *
     * @return poliçe listesi
     */
    public List<Policy> listPolicyReminderDate(Date today) {
        List<Policy> resultList = null;
        try {
            Query query = entityManager.createQuery("from Policy o where o.reminderDate< :today")
                    .setParameter("today", today);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
