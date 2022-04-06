package com.codingshadows.newsapidemo.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeService {
    public static long getCurrentTimestamp() {
        Date date = new Date();
        return date.getTime();
    }

    public String getCurrentDateForDb() {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date()).replaceAll("-", "");
    }

    public String getCurrentFormattedDateShort() {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public String getCurrentFormattedDateLong() {
        String pattern = "dd/MM/yyyy hh:mm:ss:zz";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}
