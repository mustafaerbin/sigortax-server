package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.Customer;
import com.tr.sigorta.domain.JobControl;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@Service
public class JobControlDao extends BaseDaoImpl<JobControl, Long> {

    public JobControl getNew() {
        return new JobControl();
    }

    public JobControl findJobControlByCode(String code) {
        List<JobControl> resultList = null;
        try {
            Query query = entityManager.createQuery("from JobControl o where o.code=:code")
                    .setParameter("code", code);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList.get(0);
    }

}
