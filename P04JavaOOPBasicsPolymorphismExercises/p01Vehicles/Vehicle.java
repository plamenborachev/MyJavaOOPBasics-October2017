package p01Vehicles;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;

    public Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm);
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public void drive(double distance) {
        double neededFuel = distance * this.fuelConsumptionInLitersPerKm;
        if (neededFuel > this.fuelQuantity){
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= neededFuel;
    }

    public void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
