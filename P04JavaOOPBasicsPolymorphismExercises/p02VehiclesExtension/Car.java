package p02VehiclesExtension;

public class Car extends Vehicle {
    public Car(double tankCapacity, double fuelQuantity, double fuelConsumptionInLitersPerKm){
        super(tankCapacity, fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        super.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm + 0.9);
    }
}
