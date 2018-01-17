package com.aston.businesslogic;

import com.aston.spockfunctions.SpockIntegerUtils;
import com.aston.spockfunctions.SpockStringUtils;
import com.aston.spockmain.SpockMain;
import com.aston.spockobjects.SpockObject;

public class SpockBusinessLogic {

    private SpockIntegerUtils spockIntegerUtils;
    private SpockStringUtils spockStringUtils;
    private SpockMain spockMain;

    public void setSpockIntegerUtils(SpockIntegerUtils spockIntegerUtils) {
        this.spockIntegerUtils = spockIntegerUtils;
    }

    public void setSpockStringUtils(SpockStringUtils spockStringUtils) {
        this.spockStringUtils = spockStringUtils;
    }

    public void setSpockMain(SpockMain spockMain) {
        this.spockMain = spockMain;
    }

    public void handleSpockObjectMath (SpockObject spockObject, int integer) {
        if (spockObject.getSpockBoolean()) {
            spockObject.setSpockInt(spockIntegerUtils.addition(spockObject.getSpockInt(), integer));
        } else {
            spockObject.setSpockInt(spockIntegerUtils.subtraction(spockObject.getSpockInt(), integer));
        }
        if (spockObject.getSpockInt() < 0) {
            spockObject.addErrorMessage("Are negative numbers ever acceptable, yo?");
        } else if (spockObject.getSpockInt() == 0 && spockObject.getSpockBoolean()) {
            spockObject.setSpockString(spockStringUtils.clearSpaces(spockObject.getSpockString()));
        }
        if (spockObject.getSpockBoolean() && spockObject.hasMessages()) {
            spockObject.addErrorMessage(spockStringUtils.removeA(spockObject.getErrorMessage().get(0)));
        }
        spockObject.setSpockString(spockMain.spockString(spockObject.getSpockString()));
    }


    public void validateSpockObject (SpockObject spockObject) {
        if (spockObject.getSpockBoolean() && spockObject.getSpockInt() != 1) {
            spockObject.addErrorMessage("Spock Integer must be one if Spock Boolean is true");
        }
        if (spockObject.getSpockInt() == 0 && !spockObject.getSpockString().matches("")) {
            spockObject.addErrorMessage("Spock String must be empty if Spock Integer is zero");
        }
    }
}
