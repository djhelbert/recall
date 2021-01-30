package com.recall.model;

public class Phone {
    private String countryCode;
    private String areaCode;
    private String prefix;
    private String number;

    public Phone(String countryCode, String areaCode, String prefix, String number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.number = number;
    }

    public Phone() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String normalize() {
        final StringBuilder builder = new StringBuilder();

        if (getCountryCode() != null) {
            filterNumber(getCountryCode(), builder);
        }
        if (getAreaCode() != null) {
            filterNumber(getAreaCode(), builder);
        }
        if (getPrefix() != null) {
            filterNumber(getPrefix(), builder);
        }
        if (getNumber() != null) {
            filterNumber(getNumber(), builder);
        }

        return builder.toString();
    }

    private void filterNumber(final String value, final StringBuilder builder) {
        if (value == null) {
            return;
        }

        // Remove all non numbers
        final String filtered = value.replaceAll("[^0-9]", "");

        for (int i = 0; i < filtered.length(); i++) {
            builder.append(filtered.charAt(i));
        }
    }

}
