public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double monthlyFee = 10.0;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal REJECTED for Current " + accountNumber + 
                ": Exceeds overdraft limit $" + overdraftLimit);
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Current " + accountNumber + ". New balance: $" + balance);
            if (balance < 0) System.out.println("  -> Account " + accountNumber + " is now in OVERDRAFT!");
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;
        System.out.println("End of Month - Current " + accountNumber + ": Fee $" + monthlyFee + " deducted. New balance: $" + balance);
    }
}
    

