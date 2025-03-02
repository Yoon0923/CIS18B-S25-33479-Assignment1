import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance; 
    private static int accountCounter = 1000;
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountCounter++;
        this.balance = initialBalance; } 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Must be greater than zero."); }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount. Must be greater than zero.");
        }
    }
    
    public double getBalance() {
        return balance;
    } 
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = null;
        boolean exit = false;
          System.out.println("Welcome to Simple Bank System");
        
        while (!exit) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");   
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter account holder name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter initial deposit: ");
                        double initialBalance = Double.parseDouble(scanner.nextLine());
                        
                        if (initialBalance < 0) {
                            System.out.println("Initial deposit cannot be negative.");
                        } else {
                            userAccount = new BankAccount(name, initialBalance);
                            System.out.println("Account created successfully!");
                        }
                        break;
                        
                    case 2:
                        if (userAccount == null) {
                            System.out.println("Please create an account first.");
                        } else {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = Double.parseDouble(scanner.nextLine());
                            userAccount.deposit(depositAmount);
                        }
                        break;
                        
                    case 3:
                        if (userAccount == null) {
                            System.out.println("Please create an account first.");
                        } else {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = Double.parseDouble(scanner.nextLine());
                            userAccount.withdraw(withdrawAmount);
                        }
                        break;
                        
                    case 4:
                        if (userAccount == null) {
                            System.out.println("Please create an account first.");
                        } else {
                            userAccount.displayAccountInfo();
                        }
                        break;
                        
                    case 5:
                        System.out.println("Thank you for using Simple Bank System!");
                        exit = true;
                        break;
                        
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        scanner.close();
    }}
