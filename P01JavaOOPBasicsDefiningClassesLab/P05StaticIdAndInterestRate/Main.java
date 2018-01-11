package P05StaticIdAndInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!"End".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccounts.put(account.getId(), account);
                    System.out.printf("Account %s created%n", account);
                    break;
                case "Deposit":
                    int id = Integer.valueOf(tokens[1]);
                    double amount = Double.valueOf(tokens[2]);
                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.valueOf(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.valueOf(tokens[1]);
                    int years = Integer.valueOf(tokens[2]);
                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(years));
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
