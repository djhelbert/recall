package com.recall.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneTest {
    private static final String PHONE = "18005555555";

    @Test
    public void phoneTest() {
        Phone phone = new Phone();

        phone.setCountryCode("1");
        phone.setAreaCode("800");
        phone.setPrefix("555");
        phone.setNumber("5555");

        assertEquals(PHONE, phone.normalize());

        phone.setCountryCode("+1");
        phone.setAreaCode("800 ");
        phone.setPrefix("  555");
        phone.setNumber("  -5555  ");

        assertEquals(PHONE, phone.normalize());
    }
}
