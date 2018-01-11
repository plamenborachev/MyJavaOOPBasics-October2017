package p03WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if (!"Vegetable".equalsIgnoreCase(food.getClass().getSimpleName())){
            throw new IllegalStateException("Mice are not eating that type of food!");
        }
        this.setFoodEaten(food.getQuantity());
    }
}
