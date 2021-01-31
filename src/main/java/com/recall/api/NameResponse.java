package com.recall.api;

import com.recall.model.Name;
import com.recall.model.Statistics;

public class NameResponse extends Name {
    private Statistics statistics = new Statistics();

    public NameResponse(Name name) {
        setFirst(name.getFirst());
        setMiddle(name.getMiddle());
        setLast(name.getLast());
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
