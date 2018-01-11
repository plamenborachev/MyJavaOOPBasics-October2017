import animals.Animal;
import animals.Cat;
import animals.Dog;
import centers.AdoptionCenter;
import centers.Center;
import centers.CleansingCenter;

import java.util.*;

public class AnimalCenterManager {
    private HashMap<String, Center> cleansingCenters;
    private HashMap<String, Center> adoptionCenters;
    private List<String> cleansedAnimals;
    private List<String> adoptedAnimals;

    public AnimalCenterManager() {
        this.cleansingCenters = new HashMap<>();
        this.adoptionCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        Center cleansingCenter = new CleansingCenter(name);
        cleansingCenters.putIfAbsent(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        Center adoptionCenter = new AdoptionCenter(name);
        adoptionCenters.putIfAbsent(name, adoptionCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Animal dog = new Dog(name, age, learnedCommands, adoptionCenterName);
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            this.adoptionCenters.get(adoptionCenterName).addAnimal(dog);
        }
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Animal cat = new Cat(name, age, intelligenceCoefficient, adoptionCenterName);
        if (this.adoptionCenters.containsKey(adoptionCenterName)) {
            this.adoptionCenters.get(adoptionCenterName).addAnimal(cat);
        }
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        List<Animal> animalsSendForCleansing = new ArrayList<>();
        if (this.adoptionCenters.containsKey(adoptionCenterName) && this.cleansingCenters.containsKey(cleansingCenterName)) {
            for (Animal animal : this.adoptionCenters.get(adoptionCenterName).getAnimals()) {
                if (animal.getCleansingStatus().equals(animal.getDEFAULT_CLEANSING_STATUS())) {
                    this.cleansingCenters.get(cleansingCenterName).addAnimal(animal);
                    animalsSendForCleansing.add(animal);
                }
            }
            if (animalsSendForCleansing.size() > 0) {
                for (Animal animal : animalsSendForCleansing) {
                    this.adoptionCenters.get(adoptionCenterName).removeAnimal(animal);
                }
                animalsSendForCleansing.clear();
            }
        }
    }

    public void cleanse(String cleansingCenterName) {
        if (this.cleansingCenters.containsKey(cleansingCenterName)) {
            for (Animal animal : this.cleansingCenters.get(cleansingCenterName).getAnimals()) {
                animal.cleanseAnimal();
                this.adoptionCenters.get(animal.getAdoptionCenter()).addAnimal(animal);
                this.cleansedAnimals.add(animal.getName());
            }
            this.cleansingCenters.get(cleansingCenterName).removeAnimals();
        }
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> adopted = new ArrayList<>();
        if (adoptionCenters.containsKey(adoptionCenterName)) {
            for (Animal animal : adoptionCenters.get(adoptionCenterName).getAnimals()) {
                if (animal.getCleansingStatus().equals("CLEANSED")) {
                    this.adoptedAnimals.add(animal.getName());
                    adopted.add(animal);
                }
            }
            for (Animal animal : adopted) {
                this.adoptionCenters.get(adoptionCenterName).removeAnimal(animal);
            }
            adopted.clear();
        }
    }

    public void printStatistics() {
        Collections.sort(adoptedAnimals);
        Collections.sort(cleansedAnimals);

        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics")
                .append(System.lineSeparator())
                .append(String.format("Adoption Centers: %d", this.adoptionCenters.size()))
                .append(System.lineSeparator())
                .append(String.format("Cleansing Centers: %d", this.cleansingCenters.size()))
                .append(System.lineSeparator())
                .append("Adopted Animals: ");
        if (this.adoptedAnimals.size() == 0) {
            sb.append("None");
        } else {
            sb.append(this.adoptedAnimals.toString().replaceAll("[\\[\\]]", ""))
                    .append(System.lineSeparator());
        }
        sb.append("Cleansed Animals: ");
        if (this.cleansedAnimals.size() == 0) {
            sb.append("None");
        } else {
            sb.append(this.cleansedAnimals.toString().replaceAll("[\\[\\]]", ""))
                    .append(System.lineSeparator());
        }
        int animalsAwaitingCleansing = 0;
        for (Map.Entry<String, Center> cleansingCenter : this.cleansingCenters.entrySet()) {
            for (Animal animal : cleansingCenter.getValue().getAnimals()) {
                animalsAwaitingCleansing++;
            }
        }
        int animalsAwaitingAdoption = 0;
        for (Map.Entry<String, Center> adoptionCenter : this.adoptionCenters.entrySet()) {
            for (Animal animal : adoptionCenter.getValue().getAnimals()) {
                if ("CLEANSED".equalsIgnoreCase(animal.getCleansingStatus())) {
                    animalsAwaitingAdoption++;
                }
            }
        }
        sb.append(String.format("Animals Awaiting Adoption: %d", animalsAwaitingAdoption))
                .append(System.lineSeparator())
                .append(String.format("Animals Awaiting Cleansing: %d", animalsAwaitingCleansing));
        System.out.println(sb.toString());
    }
}
