package com.recall.api;

import com.recall.model.Email;
import com.recall.model.Name;
import com.recall.model.Phone;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RecallRequest {
    private List<Email> emails = new ArrayList<>();
    private List<Phone> phones = new ArrayList<>();
    @NotNull
    private Name name;

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
}
