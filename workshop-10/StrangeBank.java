import java.util.*;

class Pair<K, V> {
    private K k;
    private V v;
    public Pair(K k, V v){
        setKey(k);
        setValue(v);
    }
    public K getKey(){ return k; }
    public V getValue(){ return v; }
    public void setKey(K k){
        this.k = k;
    }
    public void setValue(V v){
        this.v = v;
    }
}

public class StrangeBank {
    public static void main(String[] args) {
        List<Pair<String, Integer>> balance = new ArrayList<>();
        balance.add(new Pair<>("$", 1));
        balance.add(new Pair<>("€", 1));
        balance.add(new Pair<>("€", 1));
        balance.add(new Pair<>("£", 1));
        balance.add(new Pair<>("£", 1));
        balance.add(new Pair<>("£", 1));

        Account shared = new Account();
        Deposit deposit = new Deposit(shared, balance);
        Withdraw withdraw = new Withdraw(shared, balance, 1);
        try {
            deposit.start();
            withdraw.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

