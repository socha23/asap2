package pl.socha23.asap.resources;

import com.codahale.metrics.annotation.Timed;
import pl.socha23.asap.api.Hero;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/heroes")
@Produces(MediaType.APPLICATION_JSON)
public class HeroesResource {

    private int id = 0;

    private List<Hero> heroes = new ArrayList<Hero>();


    public HeroesResource() {
        heroes.addAll(Arrays.asList(
                new Hero(nextId(), "Mr. Nice", "Being super nice to other people", "Mr Rogers"),
                new Hero(nextId(), "Narco", "Able to ingest wonderous amount of drugs"),
                new Hero(nextId(), "Bombasto", "Everything he touches explodes", "Dan Emite"),
                new Hero(nextId(), "Celeritas", "Super speed"),
                new Hero(nextId(), "Magneta", "Magnetic powers"),
                new Hero(nextId(), "RubberMan", "Shapeshifter"),
                new Hero(nextId(), "Dynama", "Shoots lighting", "Eliza Powers"),
                new Hero(nextId(), "Dr IQ", "Super intelligence", "Harry Brainiac"),
                new Hero(nextId(), "Magma", "Heat-based powers", "Rita Hott"),
                new Hero(nextId(), "Tornada", "Controls weather")
        ));
    }

    @GET
    @Timed
    public Map<String, ?> get() {
        return Collections.singletonMap("data", heroes);
    }

    @POST
    @Timed
    public Map<String, ?> add(AddParams params) {
        Hero newHero = new Hero(nextId(), params.name, "(no powers)");
        heroes.add(newHero);
        return Collections.singletonMap("data", newHero);
    }

    private int nextId() {
        return ++id;
    }


    public static class AddParams {
        public String name;
    }

}
