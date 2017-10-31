package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.Agency;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Company;
import com.tr.sigorta.domain.CompanyProduct;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@Service
public class AgencyUserDao extends BaseDaoImpl<AgencyUser, Long> {

    public AgencyUser getNew() {
        return new AgencyUser();
    }

    /**
     * Acente kullanıcılarını listeler
     *
     * @param agency
     * @return
     */
    public List<AgencyUser> listAgencyUser(Agency agency) {

        List<AgencyUser> resultList = null;
        try {
            Query query = entityManager.createQuery("from AgencyUser o where o.agency=:agency")
                    .setParameter("agency", agency);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
