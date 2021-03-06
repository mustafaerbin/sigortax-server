package com.tr.sigorta.web.jobs;

import com.tr.nebula.quartz.NebulaJob;
import com.tr.nebula.quartz.NebulaTrigger;
import com.tr.nebula.quartz.info.TriggerInfo;
import com.tr.sigorta.dao.JobControlDao;
import com.tr.sigorta.dao.PolicyOldDao;
import com.tr.sigorta.domain.JobControl;
import com.tr.sigorta.domain.Policy;
import com.tr.sigorta.domain.PolicyOld;
import com.tr.sigorta.services.DateService;
import com.tr.sigorta.services.PolicyService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Erbin on 12/10/2017.
 * Bitiş tarihi geçmiş poliçeleri kapatır, PolicyOld taplosuna kaydeder.
 */
@NebulaJob(name = "PolicyOldJob", description = "Mail job.", triggers = {
        @NebulaTrigger(cron = "0 0 2 ? 1/1 MON#1 *", name = "her ayın ilk pazartesi günü", group = "jobs", type = TriggerInfo.Type.CRON),
        @NebulaTrigger(name = "On App Start", group = "Sample", type = TriggerInfo.Type.ON_APP_START)
})
@Service
public class PolicyOldJob implements Job {

    @Autowired
    JobControlDao jobControlDao;

    @Autowired
    DateService dateService;

    @Autowired
    PolicyService policyService;

    @Autowired
    PolicyOldDao policyOldDao;

    @Override
    @Transactional
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobControl jobControl = jobControlDao.findJobControlByCode("policy");
        if (jobControl.isStatus()) {
            List<Policy> policyOldList = policyService.listPolicyOld(dateService.getToday());
            if (policyOldList.size() > 0) {
                for (Policy policy : policyOldList) {
                    PolicyOld policyOld1 = policyService.oldPolicy(policy);
                    policyOldDao.create(policyOld1);
                    policyService.delete(policy);
                }
            }
        }
    }

}
