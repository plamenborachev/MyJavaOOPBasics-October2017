package p03Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();
}
