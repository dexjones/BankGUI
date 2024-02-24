import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Bank Account Manager");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }

    /*
        Written by Dexter Jones

        Pseudocode:

        Fields:

        string firstName
        string lastName
        int accountID
        double balance
        Methods:

        constructor():  initialize balance to zero
        deposit() - will accept a single value double parameter; the parameter value is added to the existing balance
        withdrawal() - accepts a single value double dollar amount; the parameter value is subtracted from the existing balance
        Setters and getters for firstName, lastName, and accountID
        getBalance() getter to return the balance
        accountSummary() - prints all account information
         */
    public static class BankAccount {
        protected String firstName;
        protected String lastName;
        protected int accountID;
        protected int idCounter;
        protected double balance;

        public BankAccount() { // default constructor
            this.firstName = "";
            this.lastName = "";
            this.accountID = ++idCounter;
            this.balance = 0;
        }

        public BankAccount(String firstName, String lastName) { // parameterized constructor
            this.firstName = firstName;
            this.lastName = lastName;
            this.accountID = ++idCounter;
            this.balance = 0;
        }
        public String getLastName() {
            return lastName;
        }
        public String getFirstName() {
            return firstName;
        }
        public int getAccountID() {
            return accountID;
        }
        public double getBalance() {
            return balance;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setAccountID(int accountID) {
            this.accountID = accountID;
        }
        public void deposit(double deposit) { // adds deposit to current balance
            balance += deposit;
        }

        public void withdrawal(double withdrawal) { // withdrawals money from balance
            balance -= withdrawal;
        }

        public String accountSummary() { // prints all account information formatted
            return String.format("First Name: '%s'\nLast Name: '%s'\nAccount ID: %d\nBalance: %.2f", firstName, lastName, accountID, balance);
        }

    }

    /*
        Written by Dexter Jones

        Implement a CheckingAccount class that inherits from the MainFrame.BankAccount class, that:

        Has an interest rate attribute
        Allows overdraft withdrawals and charges a $30 fee
        Methods:

        processWithdrawal() - will display a negative balance that includes a $30 overdraft fee and denotes that a fee has been accessed
        displayAccount() - should display all superclass attributes and provides an additional interest rate
        Ensure that your program has the two required classes and a test class.
         */
    public static class CheckingAccount extends BankAccount {
        private double interestRate;
        private boolean firstName;

        public CheckingAccount() {
            super();
            this.interestRate = 0;
        }
        public CheckingAccount(String firstName, String lastName, double interestRate) {
            super(firstName, lastName);
            this.interestRate = interestRate;
        }
        public void processWithdrawal(double amount) { //display negative balance & includes overdraft fee
            withdrawal(amount);
            if (balance < 0) {
                balance -= 30; // overdraft fee of 30$
                System.out.printf("Account overdrawn. A 30$ overdraft fee has been assessed.\nYour new balance is: $%.2f", balance);
            }
        }
        public String displayAccount() {
            return String.format("%s\nInterest rate: %.2f%%",super.accountSummary(),interestRate);
        }

    }
}
