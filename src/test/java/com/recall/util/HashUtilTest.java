package com.recall.util;

import org.junit.jupiter.api.Test;

public class HashUtilTest {
    public static final String VALUE = "robertlewisstevens@email.net";

    @Test
    public void testHash() {
        HashUtil util = new HashUtil();
        String out = util.hash(VALUE);
        System.out.println(out);
    }
}
