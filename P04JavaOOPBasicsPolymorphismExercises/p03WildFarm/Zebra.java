package p03WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (!"Vegetable".equalsIgnoreCase(food.getClass().getSimpleName())){
            throw new IllegalStateException("Zebras are not eating that type of food!");
        }
        this.setFoodEaten(food.getQuantity());
    }
}
