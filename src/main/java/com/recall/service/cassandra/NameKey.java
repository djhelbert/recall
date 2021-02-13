package com.recall.service.cassandra;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class NameKey {
    @PrimaryKeyColumn(name = "nameKey", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String nameKey;
    @PrimaryKeyColumn(name = "key", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String key;

    public NameKey(String nameKey, String key) {
        this.key = key;
        this.nameKey = nameKey;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
