package p02VehiclesExtension;

public class Bus extends Vehicle {
    public Bus(double tankCapacity, double fuelQuantity, double fuelConsumptionInLitersPerKm) {
        super(tankCapacity, fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    public void driveWithPeople(double distance) {
        double neededFuel = distance * (this.getFuelConsumptionInLitersPerKm() + 1.4);
        if (neededFuel > this.getFuelQuantity()){
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.setFuelQuantity(this.getFuelQuantity() - neededFuel);
    }
}
