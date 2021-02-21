package com.recall.model;

import com.recall.util.AddressUtil;

public class Address implements Normalized {
    private String street;
    private String apartmentNum;
    private String city;
    private String state;
    private String zip;
    private String postal;

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

    public String normalize() {
        final StringBuilder builder = new StringBuilder();

        filterString(street, builder);
        filterString(apartmentNum, builder);
        filterString(city, builder);
        filterString(state, builder);
        filterString(zip, builder);

        String value = builder.toString();
        return AddressUtil.processAbbreviations(value);
    }

    private void filterString(String value, StringBuilder builder) {
        if (value == null) {
            return;
        }

        // All lower case with whitespace removed & punctuation removed
        final String temp = value.toLowerCase().replaceAll("[^0-9a-zA-Z]", "");

        for (int i = 0; i < temp.length(); i++) {
            builder.append(temp.charAt(i));
        }
    }
}
