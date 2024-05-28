import java.util.*;
public class VendingMachine {
    private int balance;
    private Map<String, Integer> products;
    public VendingMachine() {
        balance = 0;
        products = new HashMap<>();
    }

    public void addProduct(String product, int price, int quantity) {
        products.put(product, price * quantity);
    }

    public void insertCoin(int coinValue) {
        balance += coinValue;
    }
    public int getBalance() {
        return balance;
    }

    public void displayProducts() {
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue() / 100.0);
        }
    }

    public void selectProduct(String product) {
        if (products.containsKey(product)) {
            int price = products.get(product);
            if (balance >= price) {
                dispenseProduct(product, price);
            } else {
                System.out.println("Please insert more coins.");
            }
        } else {
            System.out.println("Invalid product selection.");
        }
    }

    private void dispenseProduct(String product, int price) {
        System.out.println("Dispensing " + product);
        balance -= price;
        products.remove(product);
    }
}
