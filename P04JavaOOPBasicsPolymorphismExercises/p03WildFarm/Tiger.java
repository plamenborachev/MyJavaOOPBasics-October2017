package p03WildFarm;

public class Tiger extends Felime {
    private  String livingRegion;

    public Tiger(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (!"Meat".equalsIgnoreCase(food.getClass().getSimpleName())){
            throw new IllegalStateException("Tigers are not eating that type of food!");
        }
        this.setFoodEaten(food.getQuantity());
    }
}
