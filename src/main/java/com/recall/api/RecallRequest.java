package com.recall.api;

import com.recall.model.Email;
import com.recall.model.Name;
import com.recall.model.Phone;

import java.util.ArrayList;
import java.util.List;

public class RecallRequest {
    private List<Email> emails = new ArrayList<>();
    private List<Phone> phones = new ArrayList<>();
    private List<Name> names = new ArrayList<>();

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

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }
}
