package p09Google;

import java.util.ArrayList;

public class Person {
    private String name;
    private Company company;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Parents> parents;
    private ArrayList<Children> children;
    private Car car;

    public Person(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }
    public String getName(){
        return  this.name;
    }
    public Company getCompany(){
        return this.company;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    public ArrayList<Pokemon> getPokemons(){
        return this.pokemons;
    }
    public void setPokemons(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }
    public ArrayList<Parents> getParents() {
        return this.parents;
    }
    public void setParents(Parents parent){
        this.parents.add(parent);
    }

    public ArrayList<Children> getChildren() {
        return this.children;
    }

    public void setChildren(Children child){
        this.children.add(child);
    }
    public Car getCar(){
        return this.car;
    }
    public void setCar(Car car){
        this.car = car;
    }
}
