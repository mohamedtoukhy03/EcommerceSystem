public class Customer {
    private String name;
    private double balance;
    private Cart cart;
    
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }
    
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public Cart getCart() { return cart; }
    
    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}