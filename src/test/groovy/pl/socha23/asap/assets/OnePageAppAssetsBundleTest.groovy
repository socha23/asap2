package pl.socha23.asap.assets

import spock.lang.Specification

class OnePageAppAssetsBundleTest extends Specification {


    def "path #path leads to #asset"() {
        given:
        OnePageAppAssetsBundle bundle = new OnePageAppAssetsBundle("/assets", "/", "index.html")

        expect:
        bundle.substituteIndexFile(path) == asset

        where:
        path                 |    asset
        "/"                  |    "assets/index.html"
        "foo"                |    "assets/index.html"
        "foo/bar"            |    "assets/index.html"
        "assets/foo.gif"     |    "assets/foo.gif"
        "assets/foo/bar.gif" |    "assets/foo/bar.gif"


    }
}
