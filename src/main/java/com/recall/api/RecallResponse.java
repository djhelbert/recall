package com.recall.api;

import com.recall.model.DateOfBirth;

import java.util.ArrayList;
import java.util.List;

public class RecallResponse {
    private NameResponse name;
    private AddressResponse address;
    private DateOfBirth dateOfBirth;
    private List<EmailResponse> emails = new ArrayList<>();
    private List<PhoneResponse> phones = new ArrayList<>();

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public List<EmailResponse> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailResponse> emails) {
        this.emails = emails;
    }

    public List<PhoneResponse> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneResponse> phones) {
        this.phones = phones;
    }

    public NameResponse getName() {
        return name;
    }

    public void setName(NameResponse name) {
        this.name = name;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
