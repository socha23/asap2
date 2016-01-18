package pl.socha23.asap.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import pl.socha23.asap.api.AppInfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URL;

@Path("/app-info")
@Produces(MediaType.APPLICATION_JSON)
public class AppInfoResource {

    public final static String BUILD_INFO_FILE = "build-info.txt";

    @GET
    @Timed
    public AppInfo get() {
        return new AppInfo(readBuildInfo());
    }

    private String readBuildInfo() {
        try {
            URL url = Resources.getResource(BUILD_INFO_FILE);
            return Resources.toString(url, Charsets.UTF_8);
        } catch (IOException ioe) {
            throw new RuntimeException("Can't read " + BUILD_INFO_FILE, ioe);
        }

    }
}
