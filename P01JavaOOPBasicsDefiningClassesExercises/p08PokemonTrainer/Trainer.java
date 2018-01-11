package p08PokemonTrainer;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private int badges;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name){
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }
    public void setBadges(){
        this.badges++;
    }
    public int getBadges(){
        return this.badges;
    }
    public void setPokemons(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }
    public ArrayList<Pokemon> getPokemons(){
        return this.pokemons;
    }
}
