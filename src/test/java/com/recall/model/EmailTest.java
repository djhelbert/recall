package com.recall.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmailTest {
    private static String TEST = "test@email.net";

    @Test
    public void testEmail() {
        Email email = new Email("test@email.net");
        assertEquals(TEST, email.normalize());

        email.setAddress(" test@email.net ");
        assertEquals(TEST, email.normalize());

        email.setAddress("TEST@email.net");
        assertEquals(TEST, email.normalize());

        email.setAddress(null);
        assertNull(email.normalize());
    }
}
