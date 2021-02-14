package com.recall.model;

import javax.validation.constraints.NotNull;

public class DateOfBirth implements Normalized {
    @NotNull
    Integer month;
    @NotNull
    Integer day;
    @NotNull
    Integer year;

    public DateOfBirth(Integer month, Integer day, Integer year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public DateOfBirth() {
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String normalize() {
        return year.toString() + month.toString() + day.toString();
    }
}
