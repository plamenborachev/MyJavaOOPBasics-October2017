package p06Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender){
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private String getName() {
        return this.name;
    }

    protected void setName(String name){
        if (name == null || name.trim().length() == 0){
            throw new  IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    protected void setAge(int age){
        if (age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getGender() {
        return this.gender;
    }

    protected void setGender(String gender){
        if (!"Female".equalsIgnoreCase(gender) && !"Male".equalsIgnoreCase(gender)){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public void produceSound(){
        System.out.println("Not implemented!");
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s", this.getClass().getSimpleName(), this.getName(), this.getAge(), this.getGender());
    }
}
