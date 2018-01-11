package p02MethodOverriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double area(){
        return this.sideA * this.sideB;
    }
}
