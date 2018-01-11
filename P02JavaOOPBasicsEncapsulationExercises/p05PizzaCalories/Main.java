package p05PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\s+");
        String pizzaName = firstLine[1];
        int numberOfToppings = Integer.parseInt(firstLine[2]);
        Pizza pizza = null;
        try{
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        String[] secondLine = reader.readLine().split("\\s+");
        String flourType = secondLine[1];
        String bakingTechnique = secondLine[2];
        double weightInGrams = Double.parseDouble(secondLine[3]);
        try{
            Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        for (int i = 0; i < numberOfToppings; i++) {
            String[] toppingTokens = reader.readLine().split("\\s+");
            String toppingType = toppingTokens[1];
            double toppingWeightInGrams = Double.parseDouble(toppingTokens[2]);
            try{
                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.calculateCalories());
    }
}
