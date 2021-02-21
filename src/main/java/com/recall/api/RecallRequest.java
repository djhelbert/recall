package com.recall.api;

import com.recall.model.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RecallRequest {
    private List<Email> emails = new ArrayList<>();
    private List<Phone> phones = new ArrayList<>();
    @NotNull
    private Name name;
    private DateOfBirth dateOfBirth;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
