package com.recall.service.cassandra;

import com.recall.model.Email;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class EmailTable {
    @PrimaryKey
    private NameKey key;
    private String address;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long total;

    public EmailTable() {
    }

    public EmailTable(Email email, String nameKey) {
        this.key = new NameKey(nameKey, email.normalize());
        this.address = format(email.getAddress());
        this.created = LocalDateTime.now();
        this.updated = null;
        this.total = 1l;
    }

    private String format(String value) {
        return value == null ? null : value.trim().toLowerCase();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
