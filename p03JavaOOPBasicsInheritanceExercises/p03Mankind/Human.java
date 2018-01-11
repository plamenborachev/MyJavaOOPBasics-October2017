package p03Mankind;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName){
        checkFirstLetter(firstName);
        if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName){
        checkFirstLetter(lastName);
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }


    private void checkFirstLetter(String name) {
        if (!Character.isUpperCase(name.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s%n",
                this.getFirstName(),
                this.getLastName());
    }
}
