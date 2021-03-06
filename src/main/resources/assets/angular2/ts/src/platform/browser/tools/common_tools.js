System.register(['angular2/src/core/application_ref', 'angular2/src/facade/lang', 'angular2/src/facade/browser', 'angular2/src/platform/dom/dom_adapter'], function(exports_1) {
    var application_ref_1, lang_1, browser_1, dom_adapter_1;
    var AngularTools, AngularProfiler;
    return {
        setters:[
            function (application_ref_1_1) {
                application_ref_1 = application_ref_1_1;
            },
            function (lang_1_1) {
                lang_1 = lang_1_1;
            },
            function (browser_1_1) {
                browser_1 = browser_1_1;
            },
            function (dom_adapter_1_1) {
                dom_adapter_1 = dom_adapter_1_1;
            }],
        execute: function() {
            /**
             * Entry point for all Angular debug tools. This object corresponds to the `ng`
             * global variable accessible in the dev console.
             */
            AngularTools = (function () {
                function AngularTools(ref) {
                    this.profiler = new AngularProfiler(ref);
                }
                return AngularTools;
            })();
            exports_1("AngularTools", AngularTools);
            /**
             * Entry point for all Angular profiling-related debug tools. This object
             * corresponds to the `ng.profiler` in the dev console.
             */
            AngularProfiler = (function () {
                function AngularProfiler(ref) {
                    this.appRef = ref.injector.get(application_ref_1.ApplicationRef);
                }
                /**
                 * Exercises change detection in a loop and then prints the average amount of
                 * time in milliseconds how long a single round of change detection takes for
                 * the current state of the UI. It runs a minimum of 5 rounds for a minimum
                 * of 500 milliseconds.
                 *
                 * Optionally, a user may pass a `config` parameter containing a map of
                 * options. Supported options are:
                 *
                 * `record` (boolean) - causes the profiler to record a CPU profile while
                 * it exercises the change detector. Example:
                 *
                 * ```
                 * ng.profiler.timeChangeDetection({record: true})
                 * ```
                 */
                AngularProfiler.prototype.timeChangeDetection = function (config) {
                    var record = lang_1.isPresent(config) && config['record'];
                    var profileName = 'Change Detection';
                    // Profiler is not available in Android browsers, nor in IE 9 without dev tools opened
                    var isProfilerAvailable = lang_1.isPresent(browser_1.window.console.profile);
                    if (record && isProfilerAvailable) {
                        browser_1.window.console.profile(profileName);
                    }
                    var start = dom_adapter_1.DOM.performanceNow();
                    var numTicks = 0;
                    while (numTicks < 5 || (dom_adapter_1.DOM.performanceNow() - start) < 500) {
                        this.appRef.tick();
                        numTicks++;
                    }
                    var end = dom_adapter_1.DOM.performanceNow();
                    if (record && isProfilerAvailable) {
                        // need to cast to <any> because type checker thinks there's no argument
                        // while in fact there is:
                        //
                        // https://developer.mozilla.org/en-US/docs/Web/API/Console/profileEnd
                        browser_1.window.console.profileEnd(profileName);
                    }
                    var msPerTick = (end - start) / numTicks;
                    browser_1.window.console.log("ran " + numTicks + " change detection cycles");
                    browser_1.window.console.log(lang_1.NumberWrapper.toFixed(msPerTick, 2) + " ms per check");
                };
                return AngularProfiler;
            })();
            exports_1("AngularProfiler", AngularProfiler);
        }
    }
});
//# sourceMappingURL=common_tools.js.map