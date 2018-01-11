package animals;

public class Cat extends Animal {
    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient, String adoptionCenter) {
        super(name, age, adoptionCenter);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public int getIntelligenceCoefficient() {
        return this.intelligenceCoefficient;
    }
}
