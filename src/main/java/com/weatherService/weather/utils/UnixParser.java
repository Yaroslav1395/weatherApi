package com.weatherService.weather.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class UnixParser {

    public static Time parseUnixToTime(Integer unixTime){
        final DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        final String formattedDtm = Instant.ofEpochSecond(unixTime)
                .atZone(ZoneId.of("GMT+6"))
                .format(formatter);
        return Time.valueOf(formattedDtm);
    }

    public static Timestamp parseUnixToTimestamp(Integer unixTime){
        final DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        final String formattedDtm = Instant.ofEpochSecond(unixTime)
                .atZone(ZoneId.of("GMT+6"))
                .format(formatter);
        LocalDateTime dateTime = LocalDateTime.parse(formattedDtm);
        System.out.println(dateTime);
        return Timestamp.valueOf(dateTime);
    }
}
