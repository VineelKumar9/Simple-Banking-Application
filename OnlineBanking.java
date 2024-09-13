import java.util.Scanner;
class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be greater than 0.");
        }
    }

    public void displayAccountDetailsWithBalance() {
        System.out.println("\n----- Account Details and Balance -----");
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
        System.out.println("---------------------------------------");
    }
}

public class OnlineBanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = new BankAccount(accountHolderName, accountNumber, 0);  // Initial balance is set to 0

        while (true) {
            System.out.println("\n------------- WELCOME TO THE ONLINE BANKING APPLICATION -----");
            System.out.println("1. Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance and Account Details");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.displayAccountDetailsWithBalance();  // Display account details and balance
                    break;
                case 2:
                    System.out.println("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter the withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    account.displayAccountDetailsWithBalance();  // Display account details and balance
                    break;
                case 5:
                    System.out.println("Exiting... ----THANK YOU FOR CHOOSING ONLINE BANKING APPLICATION----");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
