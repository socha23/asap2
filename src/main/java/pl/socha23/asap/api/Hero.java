package pl.socha23.asap.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Hero model class
 */
public class Hero {

    private long id;
    private String name;
    private String power;
    private String alterEgo;

    public Hero() {
    }

    public Hero(long id, String name, String power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }

    public Hero(long id, String name, String power, String alterEgo) {
        this(id, name, power);
        this.alterEgo = alterEgo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }
}
