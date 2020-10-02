package edu.escuelaing.arep.server.model;

public class Jugador {
    private String name;
    private String country;
    private String points;

    public Jugador(String name,String country,String points) {
        this.name = name;
        this.country = country;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
