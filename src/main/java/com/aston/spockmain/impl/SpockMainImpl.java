package com.aston.spockmain.impl;

import com.aston.spockfunctions.SpockIntegerUtils;
import com.aston.spockfunctions.SpockStringUtils;
import com.aston.spockmain.SpockMain;

        public class SpockMainImpl implements SpockMain {

            private SpockStringUtils spockStringUtils;
            private SpockIntegerUtils spockIntegerUtils;

            public void setSpockStringUtils(SpockStringUtils spockStringUtils) {
                this.spockStringUtils = spockStringUtils;
            }

            public void setSpockIntegerUtils(SpockIntegerUtils spockIntegerUtils) {
                this.spockIntegerUtils = spockIntegerUtils;
            }

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
        }
