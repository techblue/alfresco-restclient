package uk.co.techblue.alfresco.dto.util;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AlfrescoDtoUtil {

    private static final String ISO8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSz";

    /**
     * Parses the ISO8601 date string.
     * 
     * @param dateString the date string
     * @return the date
     * @throws ParseException the parse exception
     */
    public static Date parseISO8601Date(String dateString) throws ParseException {
        // NOTE: SimpleDateFormat uses GMT[-+]hh:mm for the TZ which breaks
        // things a bit. Before we parse we have to repair this.
        SimpleDateFormat sdf = new SimpleDateFormat(ISO8601_PATTERN);
        // this is zero time so we need to add TZ indicator
        if (dateString.endsWith("0000Z")) {
            dateString = dateString.substring(0, dateString.indexOf("0000Z")) + "GMT-00:00";
        } else if (dateString.endsWith("Z")) {
            dateString = dateString.substring(0, dateString.length() - 1) + "GMT-00:00";
        } else {
            int inset = 6;
            String strPrefix = dateString.substring(0, dateString.length() - inset);
            String strSuffix = dateString.substring(dateString.length() - inset, dateString.length());
            dateString = strPrefix + "GMT" + strSuffix;
        }
        return sdf.parse(dateString);
    }

    /**
     * Format is o8601 date.
     * 
     * @param date the date
     * @return the string
     * @throws ParseException the parse exception
     */
    public static String formatISO8601Date(Date date) throws ParseException {
        return formatDate(date, "yyyy-MM-dd'T'HH:mm:ss.SSS'0000Z'", true);
    }

    /**
     * Format date to string using specified pattern.
     * 
     * @param date the date
     * @param pattern the pattern
     * @param toUTC the to utc
     * @return the string
     * @throws ParseException the parse exception
     */
    public static String formatDate(Date date, String pattern, boolean toUTC) throws ParseException {
        DateFormat df = new SimpleDateFormat(pattern);
        if (toUTC) {
            TimeZone tz = TimeZone.getTimeZone("UTC");
            df.setTimeZone(tz);
        }
        return df.format(date);
    }

    public static Object getClassFieldValue(Object object, String fieldName) throws IllegalArgumentException,
            IllegalAccessException {
        for (Field classField : object.getClass().getDeclaredFields()) {
            if (classField.getName().equals(fieldName)) {
                classField.setAccessible(true);
                return classField.get(object);
            }
        }
        return null;
    }

}
