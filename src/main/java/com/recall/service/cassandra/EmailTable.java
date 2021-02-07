package com.recall.service.cassandra;

import com.recall.model.Email;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class EmailTable {
    @PrimaryKey
    private String key;
    private String address;
    private LocalDateTime created;
    private Long total;

    public EmailTable() {
    }

    public EmailTable(Email email) {
        this.key = email.normalize();
        this.address = email.getAddress();
        this.created = LocalDateTime.now();
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
}
