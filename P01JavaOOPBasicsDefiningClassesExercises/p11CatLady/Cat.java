package p11CatLady;

public class Cat {
    private String name;
    private Breed breed;

    public Cat(String name, Breed breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return this.name;
    }

    public Breed getBreed() {
        return this.breed;
    }
}
