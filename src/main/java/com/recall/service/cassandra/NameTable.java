package com.recall.service.cassandra;

import com.recall.model.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class NameTable {
    @PrimaryKey
    private String key;
    private String first;
    private String middle;
    private String last;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long total;

    public NameTable() {
    }

    public NameTable(Name name) {
        this.key = name.normalize();
        this.first = format(name.getFirst());
        this.middle = format(name.getMiddle());
        this.last = format(name.getLast());
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
