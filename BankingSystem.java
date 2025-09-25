//Description: Create a banking system with different account types:Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
// Add methods like deposit(double amount) and withdraw(double amount) (concrete) and calculateInterest() (abstract).
// Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
// Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
// Use encapsulation to secure account details and restrict unauthorized access.
// Demonstrate polymorphism by processing different account types and calculating interest dynamically.


interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // e.g., 4% annual

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        if(calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Savings Account " + getAccountNumber());
        } else {
            System.out.println("Loan denied for Savings Account " + getAccountNumber());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; 
    }

    @Override
    public String toString() {
        return "SavingsAccount[Account: " + getAccountNumber() + ", Holder: " + getHolderName() + ", Balance: " + getBalance() + "]";
    }
}
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; 
    }

    @Override
    public void applyForLoan(double amount) {
        if(calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Current Account " + getAccountNumber());
        } else {
            System.out.println("Loan denied for Current Account " + getAccountNumber());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 10000; 
    }

    @Override
    public String toString() {
        return "CurrentAccount[Account: " + getAccountNumber() + ", Holder: " + getHolderName() + ", Balance: " + getBalance() + ", Overdraft: " + overdraftLimit + "]";
    }
}
public class BankingSystem{
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("S001", "Alice", 10000, 4),
            new CurrentAccount("C001", "Bob", 2000, 5000)
        };

        for(BankAccount account : accounts) {
            System.out.println(account);
            System.out.println("Interest: " + account.calculateInterest());
            if(account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                System.out.println("Loan Eligibility: " + loanable.calculateLoanEligibility());
                loanable.applyForLoan(3000);
            }
            System.out.println("----------------------------");
        }

        accounts[0].deposit(2000);
        accounts[1].withdraw(1000);
    }
}
