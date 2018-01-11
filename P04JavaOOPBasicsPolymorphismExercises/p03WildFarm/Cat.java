package p03WildFarm;

import static p03WildFarm.Main.DECIMAL_FORMAT;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    private String getBreed() {
        return this.breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        this.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getBreed(),
                DECIMAL_FORMAT.format(super.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
    }
}
