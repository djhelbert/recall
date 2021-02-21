package com.recall.util;

import java.util.HashMap;
import java.util.Map;

public class AddressUtil {
    private AddressUtil() {
    }

    public static Map<String, String> STATES = new HashMap<>() {{
        put("alabama", "al");
        put("alaska", "ak");
        put("arizona", "az");
        put("arkansas", "ar");
        put("california", "ca");
        put("colorado", "co");
        put("connecticut", "ct");
        put("delaware", "de");
        put("florida", "fl");
        put("georgia", "ga");
        put("hawaii", "ha");
        put("idaho", "id");
        put("illinois", "il");
        put("indiana", "in");
        put("iowa", "ia");
        put("kansas", "ks");
        put("kentucky", "ky");
        put("louisiana","la");
        put("maine", "me");
        put("maryland", "md");
        put("massachusetts","ma");
        put("michigan", "mi");
        put("minnesota", "mn");
        put("mississippi", "ms");
        put("missouri", "mo");
        put("montana", "mt");
        put("nebraska", "ne");
        put("nevada", "nv");
        put("new hampshire", "nh");
        put("new jersey", "nj");
        put("new mexico", "nm");
        put("new york", "ny");
        put("north carolina", "nc");
        put("north dakota", "nd");
        put("ohio", "oh");
        put("oklahoma", "ok");
        put("oregon", "or");
        put("pennsylvania", "pa");
        put("rhode island", "ri");
        put("south carolina", "sc");
        put("south dakota", "sd");
        put("tennessee", "tn");
        put("texas", "tx");
        put("utah", "ut");
        put("vermont", "vt");
        put("virginia", "va");
        put("washington", "wa");
        put("west virginia", "wv");
        put("wisconsin", "wi");
        put("wyoming", "wy");
    }};

    public static Map<String, String> ABBREVIATIONS = new HashMap<>() {{
        put("east", "e");
        put("west", "w");
        put("north", "n");
        put("south", "s");
        put("avenue", "ave");
        put("boulevard", "blvd");
        put("circle", "cr");
        put("drive", "dr");
        put("freeway", "fwy");
        put("highway", "hwy");
        put("lane", "ln");
        put("road", "rd");
        put("street", "st");
    }};

    public static String processAbbreviations(String value) {
        String result = value.toLowerCase().trim();

        for(String key : ABBREVIATIONS.keySet()) {
            result = result.replace(key, ABBREVIATIONS.get(key));
        }
        for(String key : STATES.keySet()) {
            result = result.replace(key, STATES.get(key));
        }

        return result;
    }
}
