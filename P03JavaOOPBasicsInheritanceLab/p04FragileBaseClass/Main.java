package p04FragileBaseClass;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();
        predator.feed(new Food());
        System.out.println();
    }

}
