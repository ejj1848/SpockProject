package com.aston.spockobjects;

import java.util.ArrayList;

/**
 * Created by ericjohn1 on 9/21/2016.
 */

    public class SpockObject {

        private String spockString;
        private Integer spockInt;
        private boolean spockBoolean;
        private ArrayList<String> errorMessage;

        public void addErrorMessage (String message) {
            ArrayList<String> messages = getErrorMessage();
            if (messages == null) {
                messages = new ArrayList<String>();
            }
            messages.add(message);
            setErrorMessage(messages);
        }

    public boolean hasMessages () {
        return !getErrorMessage().isEmpty();
    }

    public boolean hasErrorMessage (String message) {
        return getErrorMessage().contains(message);
    }

    public String getSpockString() {
        return spockString;
    }

    public void setSpockString(String spockString) {
        this.spockString = spockString;
    }

    public Integer getSpockInt() {
        return spockInt;
    }

    public void setSpockInt(Integer spockInt) {
        this.spockInt = spockInt;
    }

    public boolean getSpockBoolean() {
        return spockBoolean;
    }

    public void setSpockBoolean(boolean spockBoolean) {
        this.spockBoolean = spockBoolean;
    }

    public ArrayList<String> getErrorMessage() {
        return errorMessage;
    }


    private void setErrorMessage(ArrayList<String> errorMessage) {
        this.errorMessage = errorMessage;
    }
}
