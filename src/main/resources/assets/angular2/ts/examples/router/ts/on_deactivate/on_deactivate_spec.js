System.register(['angular2/src/testing/e2e_util'], function(exports_1) {
    var e2e_util_1;
    function waitForElement(selector) {
        var EC = protractor.ExpectedConditions;
        // Waits for the element with id 'abc' to be present on the dom.
        browser.wait(EC.presenceOf($(selector)), 20000);
    }
    return {
        setters:[
            function (e2e_util_1_1) {
                e2e_util_1 = e2e_util_1_1;
            }],
        execute: function() {
            describe('on activate example app', function () {
                afterEach(e2e_util_1.verifyNoBrowserErrors);
                var URL = 'angular2/examples/router/ts/on_deactivate/';
                it('should update the text when navigating between routes', function () {
                    browser.get(URL);
                    waitForElement('my-cmp');
                    expect(element(by.css('#log')).getText()).toEqual('Log:');
                    element(by.css('#param-link')).click();
                    waitForElement('my-cmp');
                    expect(element(by.css('#log')).getText()).toEqual('Log:\nNavigating from "" to "1"');
                    browser.navigate().back();
                    waitForElement('my-cmp');
                    expect(element(by.css('#log')).getText())
                        .toEqual('Log:\nNavigating from "" to "1"\nNavigating from "1" to ""');
                });
            });
        }
    }
});
//# sourceMappingURL=on_deactivate_spec.js.map