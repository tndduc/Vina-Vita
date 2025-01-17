/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.components.datetime;

import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DateFormatComponent {

    public static final String MY_DATE_FORMAT = "yyyy-MM-dd";
    public static final String MY_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public SimpleDateFormat myDateFormat() {
        return new SimpleDateFormat(MY_DATE_FORMAT);
    }

    public SimpleDateFormat myDateTimeFormat() {
        return new SimpleDateFormat(MY_DATE_TIME_FORMAT);
    }

    // public LocalDate myDateTimeFormat(String dateString) {
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MY_DATE_FORMAT);
    // LocalDate date = LocalDate.parse(dateString, formatter);
    // return date;
    // }
}
