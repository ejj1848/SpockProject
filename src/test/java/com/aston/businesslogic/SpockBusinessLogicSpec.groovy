package com.aston.businesslogic

import com.aston.spockobjects.SpockObject
import spock.lang.Specification


class SpockBusinessLogicSpec extends Specification {


    SpockBusinessLogic spockBusinessLogic = new SpockBusinessLogic(
    )


    def "test validateSpockObject"() {
        given:
        SpockObject so = new SpockObject(spockString: "A", spockInt: 0, spockBoolean: false)

        when:
        spockBusinessLogic.validateSpockObject(so)

        then:
        0 * _._

        and:
        so.hasMessages()
        so.hasErrorMessage("Spock Integer must be one if Spock Boolean is true")
        so.hasErrorMessage("Spock String must be empty if Spock Integer is zero")
        so.errorMessage.size() == 2
    }

    def "test handleSpockObjectMath"(){
        given:
        SpockObject sobj = new SpockObject(spockString: "A", spockInt: 0, spockBoolean: false)


        when:
        spockBusinessLogic.handleSpockObjectMath(sobj, int)

        then:
        0 * _._

        and:
        sobj.hasMessages()
        sobj.hasErrorMessage("Are negative numbers ever acceptable, yo?")
        sobj.errorMessage.size() == 1

    }
}