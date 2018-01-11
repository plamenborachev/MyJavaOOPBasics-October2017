package Cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower * 150 / 100);
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension * 75 / 100);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.addOns.add(tuneAddOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Add-ons: ");
        if (this.addOns.size() == 0){
            sb.append("None");
        } else {
            sb.append(this.addOns.toString().replaceAll("[\\[\\]]", ""));
        }
        return sb.toString();
    }
}
