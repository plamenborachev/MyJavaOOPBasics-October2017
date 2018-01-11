package P03BankAccountTestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        BankAccount acc = new BankAccount();
        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!"End".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int id = Integer.valueOf(tokens[1]);

            switch (command) {
                case "Create":
                    if (!bankAccounts.containsKey(id)) {
                        BankAccount account = new BankAccount();
                        account.setId(id);
                        bankAccounts.put(id, account);
                    } else {
                        System.out.println("Account already exists");
                    }
                    break;
                case "Deposit":
                    double amount = Double.valueOf(tokens[2]);
                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccounts.get(id).deposit(amount);
                    }
                    break;
                case "Withdraw":
                    amount = Double.valueOf(tokens[2]);
                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        if (amount <= bankAccounts.get(id).getBalance()) {
                            bankAccounts.get(id).withdraw(amount);
                        } else {
                            System.out.println("Insufficient balance");
                        }
                    }
                    break;
                case "Print":
                    if (!bankAccounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("Account %s, balance %.2f%n",
                                bankAccounts.get(id), bankAccounts.get(id).getBalance());
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
