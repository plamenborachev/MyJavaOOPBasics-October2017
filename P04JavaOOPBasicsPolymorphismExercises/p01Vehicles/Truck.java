package p01Vehicles;

public class Truck extends Vehicle{
    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm){
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        super.setFuelConsumptionInLitersPerKm(fuelConsumptionInLitersPerKm + 1.6);
    }

    @Override
    public void refuel(double fuel) {
        double truckFuel = fuel * 0.95;
        super.refuel(truckFuel);
    }
}
