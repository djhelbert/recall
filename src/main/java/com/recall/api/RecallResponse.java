package com.recall.api;

import java.util.ArrayList;
import java.util.List;

public class RecallResponse {
    private List<EmailResponse> emailResponses = new ArrayList<>();
    private List<PhoneResponse> phoneResponses = new ArrayList<>();
    private NameResponse nameResponse;

    public List<EmailResponse> getEmailResponses() {
        return emailResponses;
    }

    public void setEmailResponses(List<EmailResponse> emailResponses) {
        this.emailResponses = emailResponses;
    }

    public List<PhoneResponse> getPhoneResponses() {
        return phoneResponses;
    }

    public void setPhoneResponses(List<PhoneResponse> phoneResponses) {
        this.phoneResponses = phoneResponses;
    }

    public NameResponse getNameResponse() {
        return nameResponse;
    }

    public void setNameResponse(NameResponse nameResponse) {
        this.nameResponse = nameResponse;
    }
}
