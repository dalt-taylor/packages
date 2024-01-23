package edu.virginia.cs.dategetter;

public class Main {
    public static void main(String[] args) {
        DateGetter dg = new DateGetter();
        Date currentDate = dg.getCurrentDate();
        System.out.println("Today's date is " + dg.getMonthDayYearDate(currentDate));
    }
}
