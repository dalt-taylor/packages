package edu.virginia.cs.dategetter;

public interface Date {
    int getYear();
    int getMonth();
    int getDay();
    void setYear(int year);
    void setMonth(int month);
    void setDay(int day);

    void setDate(int year, int month, int day);
}
