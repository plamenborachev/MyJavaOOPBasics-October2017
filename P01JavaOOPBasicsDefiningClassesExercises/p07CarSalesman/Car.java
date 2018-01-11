package p07CarSalesman;

public class Car {
    private String carModel;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String carModel, Engine engine, int weight, String color){
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public String getCarModel(){
        return this.carModel;
    }
    public Engine getEngine(){
        return this.engine;
    }
    public int getWeight(){
        return  this.weight;
    }
    public String getColor(){
        return this.color;
    }
}
