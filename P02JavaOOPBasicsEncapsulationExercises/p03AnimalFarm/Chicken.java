package p03AnimalFarm;

public class Chicken {
    private String name;
    private int age;
    private double eggsPerDay;

    public Chicken(String name, int age){
        setName(name);
        setAge(age);
        setEggsPerDay(age);
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        if (name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    private void setAge(int age){
        if (age < 0 || 15 < age){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double getEggsPerDay(){
        return this.eggsPerDay;
    }

    private void setEggsPerDay(int age){
        if (age < 6){
            this.eggsPerDay = 2;
        } else if (age < 12){
            this.eggsPerDay = 1;
        } else {
            this.eggsPerDay = 0.75;
        }
    }

    @Override
    public String toString() {
        if (getAge() <= 12){
            return String.format("Chicken %s (age %d) can produce %.0f eggs per day.%n",
                    getName(),
                    getAge(),
                    getEggsPerDay());
        } else {
            return String.format("Chicken %s (age %d) can produce %.2f eggs per day.%n",
                    getName(),
                    getAge(),
                    getEggsPerDay());
        }

    }
}
