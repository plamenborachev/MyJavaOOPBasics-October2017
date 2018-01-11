package Cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration,
                  int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        this.horsepower += tuneIndex;
        this.suspension += (tuneIndex / 2);
    }

    public int calculatePerformancePoints(String raceType) {
        if ("CasualRace".equals(raceType)) {
            return (this.horsepower / this.acceleration) + (this.suspension + this.durability);
        } else if ("DragRace".equals(raceType)) {
            return (this.horsepower / this.acceleration);
        } else {
            return (this.suspension + this.durability);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format("%s %s %d",
                        this.getBrand(), this.getModel(), this.yearOfProduction))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s",
                        this.horsepower, this.acceleration))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability",
                        this.suspension, this.durability))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
