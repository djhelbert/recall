package com.recall.model;

public class Email {
    private String address;

    public Email(String address) {
        this.address = address;
    }

    public Email() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String normalize() {
        if (address == null) {
            return null;
        }

        return address.trim().toLowerCase();
    }
}
