package com.recall.api;

import java.util.ArrayList;
import java.util.List;

public class RecallResponse {
    private List<EmailResponse> emails = new ArrayList<>();
    private List<NameResponse> names = new ArrayList<>();
    private List<PhoneResponse> phones = new ArrayList<>();

    public List<EmailResponse> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailResponse> emails) {
        this.emails = emails;
    }

    public List<NameResponse> getNames() {
        return names;
    }

    public void setNames(List<NameResponse> names) {
        this.names = names;
    }

    public List<PhoneResponse> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneResponse> phones) {
        this.phones = phones;
    }
}
