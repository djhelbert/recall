package com.recall.model;

import javax.validation.constraints.NotBlank;

/**
 * Name
 */
public class Name implements Normalized {
    @NotBlank(message = "First name is mandatory")
    private String first;
    private String middle;
    @NotBlank(message = "Last name is mandatory")
    private String last;

    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public Name() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String normalize() {
        final StringBuilder builder = new StringBuilder();

        filterString(first, builder, false);
        filterString(middle, builder, true);
        filterString(last, builder, true);

        return builder.toString();
    }

    private void filterString(String value, StringBuilder builder, boolean leadingSpace) {
        if (value == null) {
            return;
        }

        // All lower case with whitespace removed & punctuation removed
        final String temp = value.toLowerCase().replaceAll("\\p{Punct}+", "").replaceAll("\\s", "");

        if (temp.length() > 0 && leadingSpace) {
            builder.append(' ');
        }

        for (int i = 0; i < temp.length(); i++) {
            builder.append(temp.charAt(i));
        }
    }
}
