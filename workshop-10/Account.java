public class Account {
    private double balance;
    private String currency;
    private boolean toDeposit = true;
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private void setCurrency(String currency) {
        this.currency = currency;
    }

    private String getCurrency() {
        return currency;
    }

    private double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(String currency, double amount) {
        while (!this.toDeposit) {
            try {
                if (!this.getCurrency().equals("") && !this.getCurrency().equals(currency)) {
                    System.out.println(GREEN + Thread.currentThread().getName() + RESET);
                    System.out.println(RED + "Failed to deposit! Currency mismatch!" + RESET);
                } else {
                    break;
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBalance(this.getBalance() + amount);
        this.setCurrency(currency);
        System.out.println(GREEN + Thread.currentThread().getName() + RESET + "\nDeposited " + currency + amount + " to account. Balance: " + this.getCurrency() + this.getBalance());
        this.toDeposit = false;
        notify();
    }

     public synchronized void withdraw(double amount) {
        while (this.toDeposit) {
            try {
                System.out.println(GREEN + Thread.currentThread().getName() + RESET);
                System.out.println(RED + "Failed to withdraw! Account is empty!" + RESET);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.getBalance() > 0) {
            this.setBalance(this.getBalance() - amount);
        }
        if (this.getBalance() == 0) {
            this.toDeposit = true;
        }
        System.out.println(GREEN + Thread.currentThread().getName() + RESET + "\nWithdrew " + this.getCurrency() + amount + " from account. Balance: " + this.getCurrency() + this.getBalance());
        notify();
    }
}