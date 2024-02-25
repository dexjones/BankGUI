public class BankAccount {
    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected int idCounter = 10000;
    protected double balance;

    public BankAccount() { // default constructor
        this.firstName = "";
        this.lastName = "";
        this.accountID = ++idCounter;
        this.balance = 0;
    }

    public BankAccount(String firstName, String lastName, double balance) { // parameterized constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountID = ++idCounter;
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