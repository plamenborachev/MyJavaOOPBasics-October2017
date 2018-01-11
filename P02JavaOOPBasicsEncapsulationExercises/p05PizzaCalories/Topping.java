package p05PizzaCalories;

public class Topping {
    private String type;
    private double weightInGrams;
    private double calories;

    public Topping(String type, double weightInGrams){
        this.setType(type);
        this.setWeightInGrams(weightInGrams);
        this.setCalories(weightInGrams);
    }

    private void setType(String type){
        if (!"Meat".equals(type)
                && !"Veggies".equals(type)
                && !"Cheese".equals(type)
                && !"Sauce".equals(type)){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeightInGrams(double weightInGrams){
        if (weightInGrams < 1 || 50 < weightInGrams){
            throw new IllegalArgumentException(this.type + " weight should be in the range [1..50].");
        }
        this.weightInGrams = weightInGrams;
    }

    public double getCalories(){
        return this.calories;
    }

    private void setCalories(double weightInGrams){
        double calories = weightInGrams * 2;
        if ("Meat".equals(this.type)){
            calories *= 1.2;
        } else if ("Veggies".equals(this.type)){
            calories *= 0.8;
        } else if ("Cheese".equals(this.type)){
            calories *= 1.1;
        } else if ("Sauce".equals(this.type)){
            calories *= 0.9;
        }
        this.calories = calories;
    }
}
