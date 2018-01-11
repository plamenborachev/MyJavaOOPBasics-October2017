package animals;

public abstract class Animal {
    private final String DEFAULT_CLEANSING_STATUS = "UNCLEANSED";

    private String name;
    private int age;
    private String cleansingStatus;
    private String adoptionCenter;

    protected Animal(String name, int age, String adoptionCenter) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = DEFAULT_CLEANSING_STATUS;
        this.adoptionCenter = adoptionCenter;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCleansingStatus() {
        return this.cleansingStatus;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }

    public String getDEFAULT_CLEANSING_STATUS() {
        return this.DEFAULT_CLEANSING_STATUS;
    }

    public void cleanseAnimal(){
        this.cleansingStatus = "CLEANSED";
    }
}
