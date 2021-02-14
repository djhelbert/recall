package com.recall.api;

import com.recall.model.DateOfBirth;
import com.recall.model.Statistics;

public class DateOfBirthResponse extends DateOfBirth {
    private Statistics statistics = new Statistics();

    public DateOfBirthResponse(DateOfBirth dateOfBirth) {
        setDay(dateOfBirth.getDay());
        setMonth(dateOfBirth.getMonth());
        setYear(dateOfBirth.getYear());
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
