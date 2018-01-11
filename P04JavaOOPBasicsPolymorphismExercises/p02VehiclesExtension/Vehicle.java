package p02VehiclesExtension;

public class Vehicle {
    private double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;

    public Vehicle(double tankCapacity, double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm);
    }

    private void setTankCapacity(double tankCapacity){
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        if (fuelQuantity + this.fuelQuantity > this.tankCapacity){
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumptionInLitersPerKm() {
        return this.fuelConsumptionInLitersPerKm;
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
        if (fuel <= 0){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        if (fuel + this.fuelQuantity > this.tankCapacity){
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
