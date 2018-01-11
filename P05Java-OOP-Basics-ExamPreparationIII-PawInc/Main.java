import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputTokens = reader.readLine().split(" \\| ");
        AnimalCenterManager animalCenterManager = new AnimalCenterManager();

        while(!"Paw Paw Pawah".equals(inputTokens[0])){
            switch (inputTokens[0]){
                case "RegisterCleansingCenter":
                    String name = inputTokens[1];
                    animalCenterManager.registerCleansingCenter(name);
                    break;
                case "RegisterAdoptionCenter":
                    name = inputTokens[1];
                    animalCenterManager.registerAdoptionCenter(name);
                    break;
                case "RegisterDog":
                    String dogName = inputTokens[1];
                    int age = Integer.parseInt(inputTokens[2]);
                    int learnedCommands = Integer.parseInt(inputTokens[3]);
                    String adoptionCenterName = inputTokens[4];
                    animalCenterManager.registerDog(dogName, age, learnedCommands, adoptionCenterName);
                    break;
                case "RegisterCat":
                    String catName = inputTokens[1];
                    age = Integer.parseInt(inputTokens[2]);
                    int intelligenceCoefficient = Integer.parseInt(inputTokens[3]);
                    adoptionCenterName = inputTokens[4];
                    animalCenterManager.registerCat(catName, age, intelligenceCoefficient, adoptionCenterName);
                    break;
                case "SendForCleansing":
                    adoptionCenterName = inputTokens[1];
                    String cleansingCenterName = inputTokens[2];
                    animalCenterManager.sendForCleansing(adoptionCenterName, cleansingCenterName);
                    break;
                case "Cleanse":
                    cleansingCenterName = inputTokens[1];
                    animalCenterManager.cleanse(cleansingCenterName);
                    break;
                case "Adopt":
                    adoptionCenterName = inputTokens[1];
                    animalCenterManager.adopt(adoptionCenterName);
                    break;
            }
            inputTokens = reader.readLine().split(" \\| ");
        }
        animalCenterManager.printStatistics();
    }
}
