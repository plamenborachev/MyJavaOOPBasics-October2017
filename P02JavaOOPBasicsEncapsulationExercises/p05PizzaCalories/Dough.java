package p05PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weightInGrams;
    private double calories;

    public Dough(String flourType, String bakingTechnique, double weightInGrams){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeightInGrams(weightInGrams);
        this.setCalories(weightInGrams);
    }

    private void setFlourType(String flourType){
        if (!"White".equals(flourType) && !"Wholegrain".equals(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique){
        if (!"Crispy".equals(bakingTechnique)
                && !"Chewy".equals(bakingTechnique)
                && !"Homemade".equals(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeightInGrams(double weightInGrams){
        if (weightInGrams < 1 || 200 < weightInGrams){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }

    public double getCalories(){
        return this.calories;
    }

    private void setCalories(double weightInGrams){
        double calories = weightInGrams * 2;
        if ("White".equals(this.flourType)){
            calories *= 1.5;
        }
        if ("Crispy".equals(this.bakingTechnique)){
            calories *= 0.9;
        } else if ("Chewy".equals(this.bakingTechnique)){
            calories *= 1.1;
        }
        this.calories = calories;
    }
}
