package hu.gibbonz.sfw

import spock.lang.Shared
import spock.lang.Specification

class JsonDemoSpec extends Specification {
    @Shared
    private MySimpleEjb mySimpleEjb = new MySimpleEjb()

    def test() {
        when:
        mySimpleEjb.simpleMethod()
        then:
        true
    }

    def test2() {
        when:
        mySimpleEjb.simpleMethod()
        then:
        true
    }
}
