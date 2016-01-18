package pl.socha23.asap.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Application metadata
 */
public class AppInfo {

    private String buildInfo;

    public AppInfo(String buildInfo) {
        this.buildInfo = buildInfo;
    }

    @JsonProperty
    public String getBuildInfo() {
        return buildInfo;
    }

}
