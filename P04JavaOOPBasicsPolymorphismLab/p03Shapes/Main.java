package p03Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(3, 4);
        Shape circle = new Circle(5);

        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
