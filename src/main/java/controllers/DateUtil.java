package controllers;

import util.Date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static Long getDifference(Date from,Date to) {
        return ChronoUnit.DAYS.between(jalaliToGregorian(from),jalaliToGregorian(to));
    }

    private static Date gregorianToJalali(LocalDate gregorianDate) {
        int gregorianYear = gregorianDate.getYear();
        int gregorianMonth = gregorianDate.getMonthValue();
        int gregorianDay = gregorianDate.getDayOfMonth();
        int days, jalaliMonth, jalaliDay;
        {
            int gregoryYear2 = (gregorianMonth > 2) ? (gregorianYear + 1) : gregorianYear;
            int[] g_d_m = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
            days = 355666 + (365 * gregorianYear) + ((gregoryYear2 + 3) / 4) - ((gregoryYear2 + 99) / 100) + ((gregoryYear2 + 399) / 400) + gregorianDay + g_d_m[gregorianMonth - 1];
        }
        int jalaliYear = -1595 + (33 * (days / 12053));
        days %= 12053;
        jalaliYear += 4 * (days / 1461);
        days %= 1461;
        if (days > 365) {
            jalaliYear += (days - 1) / 365;
            days = (days - 1) % 365;
        }
        if (days < 186) {
            jalaliMonth = 1 + (days / 31);
            jalaliDay = 1 + (days % 31);
        } else {
            jalaliMonth = 7 + ((days - 186) / 30);
            jalaliDay = 1 + ((days - 186) % 30);
        }
        return new Date(jalaliYear, jalaliMonth, jalaliDay);
    }

    private static LocalDate jalaliToGregorian(Date jalaliDate) {
        Integer jalaliYear = jalaliDate.getYear();
        Integer jalaliMonth = jalaliDate.getMonth();
        Integer jalaliDay = jalaliDate.getDay();
        jalaliYear += 1595;
        int days = -355668 + (365 * jalaliYear) + ((jalaliYear / 33) * 8) + (((jalaliYear % 33) + 3) / 4) + jalaliDay + ((jalaliMonth < 7) ? (jalaliMonth - 1) * 31 : ((jalaliMonth - 7) * 30) + 186);
        int gregorianYear = 400 * (days / 146097);
        days %= 146097;
        if (days > 36524) {
            gregorianYear += 100 * (--days / 36524);
            days %= 36524;
            if (days >= 365)
                days++;
        }
        gregorianYear += 4 * (days / 1461);
        days %= 1461;
        if (days > 365) {
            gregorianYear += (days - 1) / 365;
            days = (days - 1) % 365;
        }
        int gregorianMonth, gregorianDay = days + 1;
        {
            int[] sal_a = { 0, 31, ((gregorianYear % 4 == 0 && gregorianYear % 100 != 0) || (gregorianYear % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            for (gregorianMonth = 0; gregorianMonth < 13 && gregorianDay > sal_a[gregorianMonth]; gregorianMonth++) gregorianDay -= sal_a[gregorianMonth];
        }
        return LocalDate.of(gregorianYear, gregorianMonth, gregorianDay);
    }
}
