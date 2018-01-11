package p06RawData;

public class Tyre {
    private int age;
    private double pressure;

    public Tyre(int age, double pressure){
        this.age = age;
        this.pressure = pressure;
    }
    public double getPressure(){
        return this.pressure;
    }
}
