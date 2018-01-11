package p03WildFarm;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected double getAnimalWeight() {
        return this.animalWeight;
    }

    protected int getFoodEaten() {
        return this.foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected abstract void makeSound();

    protected abstract void eat(Food food);
}

