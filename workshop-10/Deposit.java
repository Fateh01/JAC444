import java.util.*;

class Deposit extends Thread {
    private final Account account;
    private final List<Pair<String, Integer>> balance;

    public Deposit(Account account, List<Pair<String, Integer>> balance) {
        super("Depositing...");
        this.balance = balance;
        this.account = account;
    }

    @Override
    public void run() {
        for (Pair<String, Integer> each : this.balance) {
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            account.deposit(each.getKey(), each.getValue());
        }
    }
}