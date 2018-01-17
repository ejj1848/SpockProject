package com.aston.spockmain

import com.aston.spockfunctions.SpockIntegerUtils
import com.aston.spockmain.impl.SpockMainImpl
import com.aston.spockfunctions.SpockStringUtils
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by ericjohn1 on 9/22/2016.
 */
class SpockMainSpec extends Specification {

    SpockStringUtils mockSpockStringUtils = Mock(SpockStringUtils)


    SpockIntegerUtils mockSpockIntegerUtils = Mock(SpockIntegerUtils)


    SpockMain spockMain = new SpockMainImpl(
            spockStringUtils: mockSpockStringUtils,
            spockIntegerUtils: mockSpockIntegerUtils
    )

    public String spockString(String string) {
        String stringB = string;
        if (string.contains("A")) {
            string = spockStringUtils.removeA(string);
            stringB = spockStringUtils.removeA(stringB);
        } else if (string.contains(" ")) {
            string = spockStringUtils.clearSpaces(string);
            stringB = string.concat("not gonna match");
        }
        if (!string.equals(stringB)) {
            string = string.toUpperCase();
            System.out.println("Capitalized.");
        }
        return string;
    }

    def "Test spockString String with an A"() {
        given:
        String string = "A string, isn't it?"
        String expected = " string, isn't it?"

        when:
        String result = spockMain.spockString(string)

        then:
        2 * mockSpockStringUtils.removeA(string) >> expected
        0 * _._


        and:
        result != string
        result == expected

    }

    def "Test String with spaces"() {
        given:
        String string = " string with spaces "
        String expected = "stringwithspaces"

        when:
        String result = spockMain.spockString(string)

        then:
        1 * mockSpockStringUtils.clearSpaces(string) >> expected
        0 * _._

        and:
        result != string
        result == expected.toUpperCase()

    }


    public Integer spockMath(int integer1, int integer2) {
        int integer3;
        int integer4;
        if (integer1 < integer2) {
            integer3 = integer1 + integer2;
            integer4 = spockIntegerUtils.addition(integer1, integer2);
        } else {
            integer3 = integer1 - integer2;
            integer4 = spockIntegerUtils.subtraction(integer1, integer2);
        }
        return integer3 - integer4;
    }

    @Unroll
    def "Test Integer Test Cases"() {
        when:
        Integer result = spockMain.spockMath(integer1, integer2)

        then:
        if (testSub) {
            1 * mockSpockIntegerUtils.subtraction(integer1, integer2) >> expected
        } else {
            1 * mockSpockIntegerUtils.addition(integer1, integer2) >> expected
        }

        and:
        result == 0

        where:
        integer1 | integer2 | testSub | expected
        1        | 2        | false   | 3
        2        | 1        | true    | 1

    }
}
