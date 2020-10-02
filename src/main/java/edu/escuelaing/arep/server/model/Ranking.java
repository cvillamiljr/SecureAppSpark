package edu.escuelaing.arep.server.model;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private List<Jugador> players;

    public Ranking() {
        players = new ArrayList<Jugador>();
        players.add(new Jugador("Novak Djokovic","Serbia","11260"));
        players.add(new Jugador("Rafael Nadal","España","9850"));
        players.add(new Jugador("Dominic Thiem","Austria","9125"));
        players.add(new Jugador("Daniil Medvedev","Rusia","5890"));
        players.add(new Jugador("Alexander Zverev","Alemania","4,650"));
        players.add(new Jugador("Matteo Berrettini","Italia","3,030"));
        players.add(new Jugador("Gael Monfils","Francia","2,860"));
        players.add(new Jugador("Roberto Bautista Agut","España","2,665"));
        players.add(new Jugador("Denis Shapovalov","Canada","2,660"));
        players.add(new Jugador("Andrey Rublev","Rusia","2,614"));
        players.add(new Jugador("David Goffin","Belgica","2,555"));
        players.add(new Jugador("Diego Schwartzman","Argentina","2,505"));
        players.add(new Jugador("Fabio Fognini","Italia","2,400"));
        players.add(new Jugador("Karen Khachanov","Rusia","2,200"));
        players.add(new Jugador("Stan Wawrinka","Suiza","2,185"));
        players.add(new Jugador("Pablo Carreño Busta","España","2,130"));
        players.add(new Jugador("Cristian Garín","Chile","2,090"));

    }

    public List<Jugador> getTeams() {
        return players;
    }

    public void setTeams(List<Jugador> players) {
        this.players = players;
    }

    public void addTeam(Jugador player){
        if(player != null)
            players.add(player);
    }
}
