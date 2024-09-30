package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

    private static final DateTimeFormatter INDIAN_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final ZoneId INDIAN_ZONE = ZoneId.of("Asia/Kolkata");

    public static String formatToIndianReadable(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            logger.error("LocalDateTime is null, cannot format date");
            return "Invalid date";  // Or handle it based on your application's needs
        }

        try {
            ZonedDateTime indianZonedDateTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(INDIAN_ZONE);
            String formattedDate = indianZonedDateTime.format(INDIAN_FORMATTER);
            logger.info("Successfully formatted date: {}", formattedDate);
            return formattedDate;
        } catch (DateTimeParseException e) {
            logger.error("Error formatting date: {}", e.getMessage(), e);
            return "Formatting error";  // Or handle it as appropriate
        } catch (Exception e) {
            logger.error("An unexpected error occurred while formatting the date: {}", e.getMessage(), e);
            return "Formatting error";  // Handle generic exceptions
        }
    }
}