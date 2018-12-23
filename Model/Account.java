package Model;



public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void increaseAccount(double amount) {
        balance+=amount;
    }

    public void decreaseAccount(double amount) {
        balance-=amount;
    }

    public double getBalance() {
        return balance;
    }
}
