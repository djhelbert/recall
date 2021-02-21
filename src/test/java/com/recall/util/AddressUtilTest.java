package com.recall.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressUtilTest {
    @Test
    public void testUtil() {
        String address = " 1234 North 82nd Street #404 Scottsdale Arizona 85255 \t";

        assertEquals("1234 n 82nd st #404 scottsdale az 85255", AddressUtil.processAbbreviations(address));

        address = " 56 E Thompson-Peak Road Phoenix AZ 85254-1000 \t";

        assertEquals("56 e thompson-peak rd phoenix az 85254-1000", AddressUtil.processAbbreviations(address));
    }
}
