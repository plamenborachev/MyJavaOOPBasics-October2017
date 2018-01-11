package p08PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!"Tournament".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).setPokemons(pokemon);

            input = reader.readLine();
        }

        input = reader.readLine();

        while (!"End".equalsIgnoreCase(input)) {
            if ("Fire".equalsIgnoreCase(input)){
                checkTrainers(input, trainers);
            } else if ("Water".equalsIgnoreCase(input)){
                checkTrainers(input, trainers);
            } else if ("Electricity".equalsIgnoreCase(input)){
                checkTrainers(input, trainers);
            }
            input = reader.readLine();
        }

        trainers.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadges(), t1.getValue().getBadges()))
                .forEach(trainer -> System.out.println(trainer.getValue().getName() + " "
                        + trainer.getValue().getBadges() + " "
                        + trainer.getValue().getPokemons().size()));
    }

    private static void checkTrainers(String input, LinkedHashMap<String, Trainer> trainers) {
        String element = input;
        for (Map.Entry<String, Trainer> trainer: trainers.entrySet()){
            if (trainer.getValue().getPokemons().stream().anyMatch(p -> p.getElement().equals(element))){
                trainer.getValue().setBadges();
            } else {
                for (int i = 0; i < trainer.getValue().getPokemons().size(); i++) {
                    trainer.getValue().getPokemons().get(i).setHealth();
                    if (trainer.getValue().getPokemons().get(i).getHealth() <= 0){
                        trainer.getValue().getPokemons().remove(i);
                        i--;
                    }
                }
            }
        }
    }
}
