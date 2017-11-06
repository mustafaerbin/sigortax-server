package com.tr.sigorta.web.jobs;

import com.tr.nebula.mail.MailItem;
import com.tr.nebula.mail.sender.NebulaMailSender;
import com.tr.nebula.quartz.NebulaJob;
import com.tr.nebula.quartz.NebulaTrigger;
import com.tr.nebula.quartz.info.TriggerInfo;
import com.tr.sigorta.dao.AgencyUserDao;
import com.tr.sigorta.dao.JobControlDao;
import com.tr.sigorta.domain.AgencyUser;
import com.tr.sigorta.domain.JobControl;
import com.tr.sigorta.domain.Policy;
import com.tr.sigorta.services.DateService;
import com.tr.sigorta.services.PolicyService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mustafa Erbin on 12/10/2017.
 * Bitiş tarihi yaklaşmış poliçeleri, kullanıcıya mail gönderir.
 */
@NebulaJob(name = "AgencyMailJob", description = "Mail job.", triggers = {
        @NebulaTrigger(cron = "0 0 7 1/1 * ? *", name = "her gün sabah 7", group = "jobs", type = TriggerInfo.Type.CRON),
        @NebulaTrigger(name = "On App Start", group = "Sample", type = TriggerInfo.Type.ON_APP_START)
})
@Service
public class AgencyMailJob implements Job {

    @Autowired
    JobControlDao jobControlDao;

    @Qualifier("mailName")
    @Autowired
    NebulaMailSender nebulaMailSender;

    @Autowired
    PolicyService policyService;

    @Autowired
    DateService dateService;

    @Autowired
    AgencyUserDao agencyUserDao;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //sendMail(); message
        JobControl jobControl = jobControlDao.findJobControlByCode("message");
        if (jobControl.isStatus()) {
            List<Policy> policyList = policyService.listPolicyReminderDate(dateService.getToday());
            List<String> receiversMail = new ArrayList<>();
            for (Policy policy : policyList) {
                List<AgencyUser> agencyUsers = agencyUserDao.listAgencyUser(policy.getAgencyUser().getAgency());
                AgencyUser agencyAdmin = getAgencyAdmin(agencyUsers);
                if (policy.getAgencyUser().getSendingMail()) {
                    receiversMail.add(policy.getAgencyUser().getEmail());
                    if (agencyAdmin != null && !policy.getAgencyUser().getUsername().equals(agencyAdmin.getUsername()))
                        receiversMail.add(agencyAdmin.getEmail());
                }
                sendMail(policy.getUserMessage() + "</br></br>" + " Müşteri Bilgileri : " + policy.getCustomer().getName(), receiversMail);

            }
        }
    }

    public void sendMail(String reminderMessage, List<String> receiversMail) {

        MailItem item = new MailItem();
        String messageBody = reminderMessage;
        item.setBody(messageBody);
        item.setTitle("Poliçe Hatırlatma Hk.");
        item.setReceivers(receiversMail);
        item.setEvent(new Event());
        nebulaMailSender.sendMail(item);
    }

    private AgencyUser getAgencyAdmin(List<AgencyUser> agencyUsers) {
        for (AgencyUser agencyUser : agencyUsers) {
            if (agencyUser.getRole().getCode().equals("AGENCY_ADMIN") && agencyUser.getSendingMail()) {
                return agencyUser;
            }
        }
        return null;
    }
}
