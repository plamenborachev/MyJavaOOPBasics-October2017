package p09Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        HashMap<String, Person> persons = new HashMap<>();

        while (!"End".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            Person person = new Person(name);
            persons.putIfAbsent(name, person);

            String infoType = tokens[1];
            if ("company".equalsIgnoreCase(infoType)){
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                Company company = new Company(companyName, department, salary);
                persons.get(name).setCompany(company);
            } else if ("pokemon".equalsIgnoreCase(infoType)){
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                persons.get(name).setPokemons(pokemon);
            } else if ("parents".equalsIgnoreCase(infoType)){
                String parentName = tokens[2];
                String parentBirthday = tokens[3];
                Parents parent = new Parents(parentName, parentBirthday);
                persons.get(name).setParents(parent);
            } else if ("children".equalsIgnoreCase(infoType)){
                String childName = tokens[2];
                String childBirthday = tokens[3];
                Children child = new Children(childName, childBirthday);
                persons.get(name).setChildren(child);
            } else if ("car".equalsIgnoreCase(infoType)){
                String carModel = tokens[2];
                int carSpeed = Integer.parseInt(tokens[3]);
                Car car = new Car(carModel, carSpeed);
                persons.get(name).setCar(car);
            }
            input = reader.readLine();
        }

        String name = reader.readLine();

        System.out.println(persons.get(name).getName());
        System.out.println("Company:");
        if (persons.get(name).getCompany() != null){
            System.out.printf("%s %s %.2f%n", persons.get(name).getCompany().getName(),
                    persons.get(name).getCompany().getDepartment(),
                    persons.get(name).getCompany().getSalary());
        }
        System.out.println("Car:");
        if (persons.get(name).getCar() != null){
            System.out.println(persons.get(name).getCar().getModel() + " " + persons.get(name).getCar().getSpeed());
        }
        System.out.println("Pokemon:");
        if (persons.get(name).getPokemons() != null){
            for (Pokemon pokemon: persons.get(name).getPokemons()) {
                System.out.println(pokemon.getName() + " " + pokemon.getType());
            }
        }
        System.out.println("Parents:");
        if (persons.get(name).getParents() != null){
            for (Parents parent: persons.get(name).getParents()) {
                System.out.println(parent.getName() + " " + parent.getBirthday());
            }
        }
        System.out.println("Children:");
        if (persons.get(name).getChildren() != null){
            for (Children child: persons.get(name).getChildren()) {
                System.out.println(child.getName() + " " + child.getBirthday());
            }
        }
    }
}
