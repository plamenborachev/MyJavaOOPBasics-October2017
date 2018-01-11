package p05PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private int numberOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        if (name.trim().length() == 0 || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setNumberOfToppings(int numberOfTopings){
        if (numberOfTopings < 0 || 10 < numberOfTopings){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfTopings;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public void setDough(Dough dough){
        this.dough = dough;
    }

    public double calculateCalories(){
        double calories = this.dough.getCalories();
        double sumToppingsCalories = this.toppings.stream().mapToDouble(Topping::getCalories).sum();
        calories += sumToppingsCalories;
        return calories;
    }
}
