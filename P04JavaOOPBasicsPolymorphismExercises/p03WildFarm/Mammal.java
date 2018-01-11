package p03WildFarm;

import static p03WildFarm.Main.DECIMAL_FORMAT;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                DECIMAL_FORMAT.format(super.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
    }
}
