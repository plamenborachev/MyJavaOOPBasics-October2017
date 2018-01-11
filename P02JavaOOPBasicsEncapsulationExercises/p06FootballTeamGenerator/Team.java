package p06FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private double rating;

    public Team(String name){
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating(){
        return  this.rating;
    }

    private void setRating(){
        if (!players.isEmpty()){
            this.rating = players.stream().mapToDouble(Player::getOverallSkill).average().getAsDouble();
        } else {
            this.rating = 0d;
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        this.setRating();
    }

    public void removePlayer(String playerName) {
        if (this.players.stream().filter(p -> p.getName().equals(playerName)).count() == 0){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.getName()));
        }
        for (Player pl: players) {
            if (playerName.equals(pl.getName())){
                players.remove(pl);
                this.setRating();
                break;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f",  this.getName(), this.getRating());
    }
}
