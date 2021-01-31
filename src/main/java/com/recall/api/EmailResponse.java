package com.recall.api;

import com.recall.model.Email;
import com.recall.model.Statistics;

public class EmailResponse extends Email {

    private Statistics statistics = new Statistics();

    public EmailResponse(Email email) {
        setAddress(email.getAddress());
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
