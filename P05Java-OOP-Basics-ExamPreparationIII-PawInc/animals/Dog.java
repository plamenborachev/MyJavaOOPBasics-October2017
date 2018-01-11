package animals;

public class Dog extends Animal {
    private int amountOfCommands;

    public Dog(String name, int age, int amountOfCommands, String adoptionCenter) {
        super(name, age, adoptionCenter);
        this.amountOfCommands = amountOfCommands;
    }

    public int getAmountOfCommands() {
        return this.amountOfCommands;
    }
}
