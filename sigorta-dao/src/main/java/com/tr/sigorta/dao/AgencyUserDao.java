package com.tr.sigorta.dao;

import com.tr.nebula.persistence.jpa.dao.BaseDaoImpl;
import com.tr.sigorta.domain.AgencyUser;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Erbin on 16/09/2017.
 */
@Service
public class AgencyUserDao extends BaseDaoImpl<AgencyUser, Long> {

    public AgencyUser getNew() {
        return new AgencyUser();
    }
}
