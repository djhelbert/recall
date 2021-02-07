package com.recall.service.cassandra;

import com.recall.model.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class NameTable {
    @PrimaryKey
    private String key;
    private String first;
    private String middle;
    private String last;
    private Long total;

    public NameTable() {
    }

    public NameTable(Name name) {
        this.key = name.normalize();
        this.first = name.getFirst();
        this.middle = name.getMiddle();
        this.last = name.getLast();
        this.total = 1l;
    }

    public void increment() {
        this.total = total + 1;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
