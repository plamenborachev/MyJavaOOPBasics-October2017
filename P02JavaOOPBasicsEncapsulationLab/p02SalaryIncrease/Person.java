package p02SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getAge(){
        return this.age;
    }

    public double getSalary(){
        return this.salary;
    }

    public void increaseSalary(int bonus) {
        if (this.getAge() < 30){
            this.salary += this.salary * ((double)bonus / (100 * 2));
        } else {
            this.salary += this.salary * ((double)bonus / 100);
        }
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " gets " + this.getSalary() + " leva";
    }


}
