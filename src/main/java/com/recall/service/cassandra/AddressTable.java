package com.recall.service.cassandra;

import com.recall.model.Address;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class AddressTable {
    @PrimaryKey
    private NameKey key;
    private String street;
    private String apartmentNum;
    private String city;
    private String state;
    private String zip;
    private String postal;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long total;

    public AddressTable(Address address, String nameKey) {
        this.key = new NameKey(nameKey, address.normalize());
        this.street = address.getStreet();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.state = address.getState();
        this.zip = address.getZip();
        this.postal = address.getPostal();
        this.created = LocalDateTime.now();
        this.updated = null;
        this.total = 1l;
    }

    public AddressTable() {
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
