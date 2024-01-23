package edu.virginia.cs.dategetter;


import java.time.*;

public class DateGetter {
    /**
     * Takes in a year, month, and day and return that as a Date Object
     *
     * @throws IllegalArgumentException if date is invalid.
     */
    public Date getDate(int year, int month, int day) {
        return new DateImpl(year, month, day);
    }

    /**
     * Returns whether or not a given date is valid.
     */
    public boolean isValidDate(int year, int month, int day) {
        try {
            Date myDate = new DateImpl(year, month, day);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Returns the current date as a Date Object
     */
    public Date getCurrentDate() {
        ZonedDateTime now = ZonedDateTime.now();
        return new DateImpl(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth());
    }

    /**
     * Returns a date in Month-Day-Year format. Example: "8-23-2022"
     */
    public String getMonthDayYearDate(Date date) {
        return date.getMonth() + "-" + date.getDay() + "-" + date.getYear();
    }

    /**
     * Returns a date in Day-Month-Year format. Example: "23-8-2022"
     */
    public String getDayMonthYearDate(Date date) {
        return date.getDay() + "-" + date.getMonth() + "-" + date.getYear();
    }

    /**
     * Returns a date in Year-Month-Day format. Example: "2022-8-23"
     */
    public String getYearMonthDayDate(Date date) {
        return date.getYear() + "-" + date.getMonth() + "-" + date.getDay();
    }
}
