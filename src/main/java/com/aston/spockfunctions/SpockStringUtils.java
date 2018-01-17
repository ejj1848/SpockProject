package com.aston.spockfunctions;

/**
 * Created by ericjohn1 on 9/21/2016.
 */
public class SpockStringUtils {

    public String removeA (String string) {
        return string.replaceAll("A", " ");
    }

    public String clearSpaces (String string) {
        return string.replaceAll(" ", "");
    }

}
