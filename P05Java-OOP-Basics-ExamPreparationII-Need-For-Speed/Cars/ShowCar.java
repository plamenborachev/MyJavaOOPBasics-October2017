package Cars;

public class ShowCar extends Car {
    private final int DEFAULT_STARS = 0;
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = DEFAULT_STARS;
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        return String.format("%s%d *", super.toString(), this.stars);
    }
}
