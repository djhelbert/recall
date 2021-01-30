package com.recall.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {
    private static final String NAME = "robert lewis stevens";

    @Test
    public void testName() {
        Name name = new Name();

        name.setFirst("Robert");
        name.setMiddle("Lewis");
        name.setLast("STEVENS");

        assertEquals(NAME, name.normalize());

        name.setFirst(" Robert ");
        name.setMiddle("lewis ");
        name.setLast(" STEVENS");

        assertEquals(NAME, name.normalize());
    }
}
