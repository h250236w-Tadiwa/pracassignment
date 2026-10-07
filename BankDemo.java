 import java.util.*;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV01", 1000.0, 200.0));
        accounts.add(new CurrentAccount("CUR01", 500.0, 300.0));
        accounts.add(new SavingsAccount("SAV02", 300.0, 50.0));
        accounts.add(new CurrentAccount("CUR02", 100.0, 500.0));

        System.out.println(" Initial Balances");
        for (Account acc : accounts) {
            System.out.println(acc.getAccountNumber() + " Balance: $" + acc.getBalance());
        }

        System.out.println("   Polymorphic Withdrawals (Account reference only)");
        for (Account acc : accounts) {
            acc.withdraw(100.0);
        }

        System.out.println("    Savings REJECTED ");
        accounts.get(2).withdraw(150.0);

        System.out.println("      Current goes into overdraft within limit");
        accounts.get(3).withdraw(400.0);

        System.out.println("       End of Month (polymorphic)");
        for (Account acc : accounts) {
            acc.endOfMonth();
        }

        System.out.println("        Final Balances ");
        for (Account acc : accounts) {
            System.out.println(acc.getAccountNumber() + " Final: $" + acc.getBalance());
        }
    }
}   


