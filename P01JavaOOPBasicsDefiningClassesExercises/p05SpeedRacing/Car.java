package p05SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public String getModel(){
        return this.model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public void setFuelAmount(int amountOfKm){
        this.fuelAmount -= this.fuelCost * amountOfKm;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void setDistanceTraveled(int amountOfKm){
        this.distanceTraveled += amountOfKm;
    }

    public boolean ifCarCanMoveSomeDistance(int amountOfKm){
        if (this.fuelAmount >= amountOfKm * this.fuelCost ){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d%n", this.model, this.fuelAmount, this.getDistanceTraveled());
    }
}
