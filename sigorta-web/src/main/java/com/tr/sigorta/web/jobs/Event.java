package com.tr.sigorta.web.jobs;

import com.tr.nebula.mail.MailEvent;
import com.tr.nebula.mail.MailItem;

/**
 * Created by Mustafa Erbin on 18/10/17.
 */
public class Event implements MailEvent {
    @Override
    public void before(MailItem item) {

    }

    @Override
    public void success(MailItem item) {

    }

    @Override
    public void error(MailItem item, Exception e) {

    }
}
