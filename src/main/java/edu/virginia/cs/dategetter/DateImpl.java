package edu.virginia.cs.dategetter;

public class DateImpl implements Date {
    private int year, month, day;

    protected DateImpl(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Error: Invalid Date");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        if (isValidYear(year)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Error: Invalid year entered: " + year);
        }
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public void setMonth(int month) {
        if(isValidMonth(month)) {
            this.month = month;
        } else  {
            throw new IllegalArgumentException("Error: Invalid month entered: " + month);
        }
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public void setDay(int day) {
        if(isValidDate(year, month, day)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Error: Invalid day entered: " + year + "-" + month + "-" + day);
        }
    }

    private boolean isValidYear(int year) {
        return year > 0;
    }

    private boolean isValidMonth(int month) {
        return 1 <= month && month <= 12;
    }

    @Override
    public void setDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            changeDate(year, month, day);
        } else {
            throw new IllegalArgumentException("Error: invalid day entered: "  + year + "-" + month + "-" + day);
        }
    }

    private boolean isValidDate(int year, int month, int day) {
        if (!isYearAndMonthValid(year, month)) {
            return false;
        }
        return isDayValidForYearAndMonth(year, month, day);
    }


    private boolean isYearAndMonthValid(int year, int month) {
        return isValidYear(year) && isValidMonth(month);
    }

    private boolean isDayValidForYearAndMonth(int year, int month, int day) {
        return switch (month) {
            case 2 -> isValidFebruaryDay(year, day);
            case 4, 6, 9, 11 -> isDayPositiveAndLessThanMax(day, 30);
            default -> isDayPositiveAndLessThanMax(day, 31);
        };
    }

    private boolean isDayPositiveAndLessThanMax(int day, int maxDaysInMonth) {
        return 1 <= day && day <= maxDaysInMonth;
    }

    private boolean isValidFebruaryDay(int year, int day) {
        if (isLeapYear(year)) {
            return isDayPositiveAndLessThanMax(day, 29);
        } else {
            return isDayPositiveAndLessThanMax(day, 28);
        }
    }

    private boolean isLeapYear(int year) {
        if (isYearDivisibleBy(year, 400)) {
            return true;
        } else if (isYearDivisibleBy(year, 100)) {
            return false;
        } else return isYearDivisibleBy(year, 4);
    }

    private boolean isYearDivisibleBy(int year, int divisor) {
        return year % divisor == 0;
    }

    private void changeDate(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    @Override
    public String toString() {
        return "DateImpl{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
