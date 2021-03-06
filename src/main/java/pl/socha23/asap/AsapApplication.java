package pl.socha23.asap;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import pl.socha23.asap.assets.OnePageAppAssetsBundle;
import pl.socha23.asap.health.BuildInfoHealthCheck;
import pl.socha23.asap.resources.AppInfoResource;
import pl.socha23.asap.resources.HeroesResource;

public class AsapApplication extends Application<AsapConfiguration> {

    public static void main(String[] args) throws Exception {
        new AsapApplication().run(args);
    }

    @Override
    public String getName() {
        return "asap2";
    }

    @Override
    public void initialize(Bootstrap<AsapConfiguration> bootstrap) {
        bootstrap.addBundle(new OnePageAppAssetsBundle("/assets", "/", "index.html"));

    }

    @Override
    public void run(AsapConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new AppInfoResource());
        environment.healthChecks().register("build info", new BuildInfoHealthCheck());

        environment.jersey().register(new HeroesResource());
    }
}
