package com.recall.model;

import javax.validation.constraints.NotBlank;

public class Email implements Normalized {
    @NotBlank(message = "Address is mandatory")
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
