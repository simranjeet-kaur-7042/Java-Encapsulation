//Create a BankAccount class with the following features:
// Static:A static variable bankName shared across all accounts.A static method getTotalAccounts() to display the total number of accounts.
// This:Use this to resolve ambiguity in the constructor when initializing accountHolderName and accountNumber.
// Final:Use a final variable accountNumber to ensure it cannot be changed once assigned.
// Instanceof:Check if an account object is an instance of the BankAccount class before displaying its details.

class Bank{
    private static String bankName="Central Bank";
    private static int totalAccounts=0;
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    public Bank(int accountNumber,String accountHolderName,double balance){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance=balance;
        totalAccounts++;
    }

    public void displayAccountDetails(){
        if(this instanceof Bank){
            System.out.println("Bank Name : "+bankName);
            System.out.println("Account Number : "+accountNumber);
            System.out.println("Account Holder : "+accountHolderName);
            System.out.println("Balance : "+balance);

        }
    }

    public static void getTotalAccounts(){
        System.out.println("Total Bank Accounts : "+totalAccounts);
    }
}

class BankAccount{
    public static void main(String[] args) {
        Bank ac1=new Bank(101,"karan",500000);
        Bank ac2=new Bank(102,"Aman",800000);
        ac1.displayAccountDetails();
        ac2.displayAccountDetails();
        Bank.getTotalAccounts();
    }
}