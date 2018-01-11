package p06Animals;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender){
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!"Female".equalsIgnoreCase(gender)){
            throw new IllegalArgumentException("Invalid input!");
        }
        super.setGender(gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }
}
