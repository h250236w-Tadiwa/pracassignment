public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate = 0.03;

    public SavingsAccount(String accountNumber, double balance, double minimumBalance) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal REJECTED for Savings " + accountNumber + 
                ": Cannot go below minimum $" + minimumBalance + ". Current: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Savings " + accountNumber + ". New balance: $" + balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("End of Month - Savings " + accountNumber + ": Interest $" + interest + " applied. New balance: $" + balance);
    }   
}
