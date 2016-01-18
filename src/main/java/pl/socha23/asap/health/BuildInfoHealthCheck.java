package pl.socha23.asap.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import pl.socha23.asap.resources.AppInfoResource;

import java.net.URL;

public class BuildInfoHealthCheck extends HealthCheck {

    private String buildInfoFile;

    public BuildInfoHealthCheck() {
        this(AppInfoResource.BUILD_INFO_FILE);
    }

    public BuildInfoHealthCheck(String buildInfoFile) {
        this.buildInfoFile = buildInfoFile;
    }


    @Override
    protected Result check() throws Exception {
        try {
            URL url = Resources.getResource(buildInfoFile);
            String info = Resources.toString(url, Charsets.UTF_8);
            return Result.healthy();
        } catch (Exception e) {
            return Result.unhealthy("Can't read build info from " + buildInfoFile);
        }


    }
}
