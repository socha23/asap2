package pl.socha23.asap.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import pl.socha23.asap.api.AppInfo;
import pl.socha23.asap.api.Hero;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Path("/heroes")
@Produces(MediaType.APPLICATION_JSON)
public class HeroesResource {

    private List<Hero> heroes = Arrays.asList(
            new Hero(11, "Mr. Nice", "Being super nice to other people", "Mr Rogers"),
            new Hero(12, "Narco", "Able to ingest wonderous amount of drugs"),
            new Hero(13, "Bombasto", "Everything he touches explodes", "Dan Emite"),
            new Hero(14, "Celeritas", "Super speed"),
            new Hero(15, "Magneta", "Magnetic powers"),
            new Hero(16, "RubberMan", "Shapeshifter"),
            new Hero(17, "Dynama", "Shoots lighting", "Eliza Powers"),
            new Hero(18, "Dr IQ", "Super intelligence", "Harry Brainiac"),
            new Hero(19, "Magma", "Heat-based powers", "Rita Hott"),
            new Hero(20, "Tornada", "Controls weather")
    );

    @GET
    @Timed
    public Collection<Hero> get() {
        return heroes;
    }
}
