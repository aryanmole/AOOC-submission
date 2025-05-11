import java.util.Scanner;

class LowBalanceException extends Exception {
    LowBalanceException(String message) {
        super(message);
    }
}

class NegativeNumberException extends Exception {
    NegativeNumberException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    void balanceEnquiry() {
        System.out.println("Current Balance: ₹" + balance);
    }

    void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot deposit a negative amount.");
        }
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    void withdraw(double amount) throws LowBalanceException, NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new LowBalanceException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount(5000.0); // Starting balance

        int choice;
        do {
            System.out.println("\n1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        acc.balanceEnquiry();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        acc.deposit(dep);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        acc.withdraw(wd);
                        break;
                    case 4:
                        System.out.println("Thank you for using the bank app.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (LowBalanceException | NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 4);

        sc.close();
    }
}
