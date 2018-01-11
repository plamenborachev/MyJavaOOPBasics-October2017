package p06Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while (!"Beast!".equalsIgnoreCase(input)) {
            String kind = input;
            String[] animalTokens = reader.readLine().split("\\s+");
            String name = animalTokens[0];
            int age = Integer.parseInt(animalTokens[1]);
            String gender = animalTokens[2];

            try {
                Animal animal = null;
                switch (kind) {
                    case "Animal":
                        animal = new Animal(name, age, gender);
                        break;
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age, gender);
                        break;
                    default:
                        System.out.println("Invalid input!");
                        return;
                }
                System.out.println(animal);
                animal.produceSound();
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            input = reader.readLine();
        }
    }
}
