package p06Animals;

public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender){
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!"Male".equalsIgnoreCase(gender)){
            throw new IllegalArgumentException("Invalid input!");
        }
        super.setGender(gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Give me one million b***h");
    }
}
