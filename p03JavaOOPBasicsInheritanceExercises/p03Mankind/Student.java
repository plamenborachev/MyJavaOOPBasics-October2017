package p03Mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber){
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber){
        if(facultyNumber.length() < 5 || 10 < facultyNumber.length()){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Faculty number: %s%n", this.getFacultyNumber());
    }
}
