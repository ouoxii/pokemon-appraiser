package com.example.pokemon_appraiser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    public static String[] find(String string) {

        String[] array = new String[2];

        // create regular expression
        Pattern expression1 = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{1,2}");
        Pattern expression2 = Pattern.compile("CP (\\d+)");

        // match regular expression to string and print matches
        Matcher matcher1 = expression1.matcher(string);
        Matcher matcher2 = expression2.matcher(string);

        if (matcher1.find()) {
            array[0] = matcher1.group();
        }

        if (matcher2.find()) {
            array[1] = matcher2.group(1);
        }

        return array;
    }
}
