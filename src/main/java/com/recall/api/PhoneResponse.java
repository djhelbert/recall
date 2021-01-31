package com.recall.api;

import com.recall.model.Phone;
import com.recall.model.Statistics;

public class PhoneResponse extends Phone {
    private Statistics statistics = new Statistics();

    public PhoneResponse(Phone phone) {
        setCountryCode(phone.getCountryCode());
        setAreaCode(phone.getAreaCode());
        setPrefix(phone.getPrefix());
        setNumber(phone.getNumber());
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
