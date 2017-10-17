package com.tr.sigorta.services;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mustafa Erbin on 17/10/2017.
 * Tarih işlemleri.
 */
@Service
public class DateService {

    public DateFormat getDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * BUGUN
     *
     * @return
     */
    public Date getToday() {
        Date todayQ = null;
        try {
            DateFormat formatq = getDateFormat();
            Date today = new Date();
            todayQ = formatq.parse(formatq.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return todayQ;
    }
}
