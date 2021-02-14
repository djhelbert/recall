package com.recall.service.cassandra;

import com.recall.model.DateOfBirth;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class DateOfBirthTable {
    @PrimaryKey
    private NameKey key;
    private Integer month;
    private Integer day;
    private Integer year;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long total;

    public DateOfBirthTable(DateOfBirth dateOfBirth, String nameKey) {
        this.key = new NameKey(nameKey, dateOfBirth.normalize());
        this.month = dateOfBirth.getMonth();
        this.day = dateOfBirth.getDay();
        this.month = dateOfBirth.getMonth();
        this.created = LocalDateTime.now();
        this.updated = null;
        this.total = 1l;
    }

    public DateOfBirthTable() {
    }

    public void increment() {
        this.total = total + 1;
        this.updated = LocalDateTime.now();
    }

    public NameKey getKey() {
        return key;
    }

    public void setKey(NameKey key) {
        this.key = key;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
