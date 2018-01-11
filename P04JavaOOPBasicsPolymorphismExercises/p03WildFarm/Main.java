package p03WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    private static final String PATTERN = "#.##";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(PATTERN);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] animalTokens = reader.readLine().split("\\s+");
        List<Animal> animals = new LinkedList<>();

        while (!"End".equalsIgnoreCase(animalTokens[0])) {
            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            double animalWeight = Double.parseDouble(animalTokens[2]);
            String animalLivingRegion = animalTokens[3];
            String breed = null;
            if ("Cat".equalsIgnoreCase(animalType)) {
                breed = animalTokens[4];
            }

            Animal animal = getAnimal(animalType, animalName, animalWeight, animalLivingRegion, breed);

            String[] foodTokens = reader.readLine().split("\\s+");
            String foodType = foodTokens[0];
            int quantity = Integer.parseInt(foodTokens[1]);

            Food food = getFood(foodType, quantity);

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
            animals.add(animal);

            animalTokens = reader.readLine().split("\\s+");
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Animal getAnimal(String animalType, String animalName, double animalWeight, String animalLivingRegion, String breed) {
        Animal animal = null;
        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalType, animalName, animalWeight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalType, animalName, animalWeight, animalLivingRegion);
                break;
            case "Tiger":
                animal = new Tiger(animalType, animalName, animalWeight, animalLivingRegion);
                break;
            case "Cat":
                animal = new Cat(animalType, animalName, animalWeight, animalLivingRegion, breed);
                break;
        }
        return animal;
    }

    private static Food getFood(String foodType, int quantity) {
        Food food = null;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(quantity);
                break;
            case "Meat":
                food = new Meat(quantity);
                break;
        }
        return food;
    }
}
