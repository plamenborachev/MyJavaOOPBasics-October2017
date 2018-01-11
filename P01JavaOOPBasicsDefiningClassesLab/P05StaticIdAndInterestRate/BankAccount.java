package P05StaticIdAndInterestRate;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private int id;
    private double balance;
    private static double interestRate;
    private static int bankAccountsCount;

    public BankAccount(){
        this.id = ++bankAccountsCount;
        interestRate = DEFAULT_INTEREST;
    }

    public int getId(){
        return this.id;
    }

    public static void setInterestRate(double interest){
        interestRate = interest;
    }
    public double getInterest(int years){
        return this.balance * interestRate * years;
    }
    public void deposit (double amount){
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id   ;
    }
}
