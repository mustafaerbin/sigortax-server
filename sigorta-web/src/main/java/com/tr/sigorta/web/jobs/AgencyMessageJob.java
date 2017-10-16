package com.tr.sigorta.web.jobs;

import com.tr.nebula.quartz.NebulaJob;
import com.tr.nebula.quartz.NebulaTrigger;
import com.tr.nebula.quartz.info.TriggerInfo;
import com.tr.sigorta.dao.JobControlDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mustafa Erbin on 12/10/2017.
 */
@NebulaJob(name = "AgencyMessageJob", description = "Mail job.", triggers = {
        @NebulaTrigger(cron = "0 0 7 1/1 * ? *", name = "her gün sabah 7", group = "jobs", type = TriggerInfo.Type.CRON),
        @NebulaTrigger(name = "On App Start", group = "Sample", type = TriggerInfo.Type.ON_APP_START)
})
public class AgencyMessageJob implements Job {

    @Autowired
    JobControlDao jobControlDao;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }
}
