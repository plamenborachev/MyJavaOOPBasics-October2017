package p11CatLady;

public class Breed {
    private String name;
    double specificCharacteristic;

    public Breed(String name, double specificCharacteristic) {
        this.name = name;
        this.specificCharacteristic = specificCharacteristic;
    }

    public String getName() {
        return this.name;
    }

    public double getSpecificCharacteristic() {
        return this.specificCharacteristic;
    }
}
