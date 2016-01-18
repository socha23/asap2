package pl.socha23.asap.health

import spock.lang.Specification

class BuildInfoHealthCheckTest extends Specification {

    def "check reports healthy for real build info file"() {
        expect:
        new BuildInfoHealthCheck().check().healthy
    }

    def "check reports unhealthy for non existing build info file"() {
        expect:
        !new BuildInfoHealthCheck("i_dont_exist").check().healthy
    }


}
