package es.upm.miw.apaw_practice.domain.models.basketball;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String city;
    private Integer numPlayers;
    private String coach;
    private List<Player> players;


    public Team() {
        this.players = new ArrayList<>();
    }

    public Team(String city, Integer numPlayers, String coach) {
        this.city = city;
        this.numPlayers = numPlayers;
        this.coach = coach;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }


    @Override
    public String toString() {
        return "Team{" +
                "numPlayers='" + numPlayers + '\'' +
                ", coach=" + coach +
                ", city='" + city + '\'' +
                '}';
    }
}