package p03Mankind;

public class Worker extends Human{
    private double weekSalary;
    private double workHoursPerDay;
    private double salaryPerHour;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay){
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWeekSalary(double weekSalary){
        if (weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(double workHoursPerDay){
        if (workHoursPerDay < 1 || 12 < workHoursPerDay){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.salaryPerHour = this.getWeekSalary() / (this.getWorkHoursPerDay() * 7);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Week Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f%n",
                this.getWeekSalary(),
                this.getWorkHoursPerDay(),
                this.getSalaryPerHour());
    }
}
