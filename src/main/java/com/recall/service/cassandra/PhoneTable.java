package com.recall.service.cassandra;

import com.recall.model.Phone;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class PhoneTable {
    @PrimaryKey
    private String key;
    private String countryCode;
    private String areaCode;
    private String prefix;
    private String number;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long total;

    public PhoneTable() {
    }

    public PhoneTable(Phone phone) {
        this.areaCode = phone.getAreaCode();
        this.countryCode = phone.getCountryCode();
        this.number = phone.getNumber();
        this.prefix = phone.getPrefix();
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        this.total = 1l;
    }

    public void increment() {
        this.total = total + 1;
        this.updated = LocalDateTime.now();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
