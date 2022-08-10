import java.util.*;

public class Withdraw extends Thread {
    private final int withdraw;
    private final Account account;
    private final List<Pair<String, Integer>> balance;

    public Withdraw(Account account, List<Pair<String, Integer>> balance, int withdraw) {
        super("Processing Withdrawal...");
        this.account = account;
        this.balance = balance;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < this.balance.size()) {
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            this.account.withdraw(withdraw);
            counter++;
        }
    }
}