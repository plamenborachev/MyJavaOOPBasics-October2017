package p04FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary){
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName(){
        return this.firstName;
    }

    private void setFirstName(String firstName){
        if (firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    private void setLastName(String lastName){
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge(){
        return this.age;
    }

    private void setAge(int age){
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary(){
        return this.salary;
    }

    private void setSalary(double salary){
        if (salary < 460.0){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
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
