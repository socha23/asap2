package pl.socha23.asap.resources

import spock.lang.Specification

class AppInfoResourceTest extends Specification {

    def "appInfo contains build info"() {
        given:
        def info = new AppInfoResource().get()?.getBuildInfo()

        expect:
        info != null
        info != ""
    }
}
