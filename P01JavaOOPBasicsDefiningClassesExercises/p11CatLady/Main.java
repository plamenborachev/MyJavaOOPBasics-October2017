package p11CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        ArrayList<Cat> cats = new ArrayList<>();

        while (!"End".equalsIgnoreCase(input)){
            String[] catTokens = input.split("\\s+");
            String breedName = catTokens[0];
            String catName = catTokens[1];
            double specificCharacteristic = Double.parseDouble(catTokens[2]);

            Breed breed = new Breed(breedName, specificCharacteristic);
            Cat cat = new Cat(catName, breed);
            cats.add(cat);

            input = reader.readLine();
        }

        String catName = reader.readLine();

        for (Cat cat: cats) {
            if (cat.getName().equals(catName)){
                System.out.printf("%s %s %.2f%n", cat.getBreed().getName(), cat.getName(), cat.getBreed().getSpecificCharacteristic());
                break;
            }
        }
    }
}
