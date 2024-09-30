package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final DateTimeFormatter INDIAN_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private static final ZoneId INDIAN_ZONE = ZoneId.of("Asia/Kolkata");

    public static String formatToIndianReadable(LocalDateTime localDateTime) {
        ZonedDateTime indianZonedDateTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(INDIAN_ZONE);
        return indianZonedDateTime.format(INDIAN_FORMATTER);
    }
}