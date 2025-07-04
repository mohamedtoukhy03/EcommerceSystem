import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Product {
    private static Map<String, Product> products = new HashMap<>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private String name;
    private double price;
    private int quantity;
    private double weight;
    private LocalDateTime expiryDate;
    private boolean isShippable;

    private Product(String name, double price, int quantity, double weight, 
                   LocalDateTime expiryDate, boolean isShippable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.expiryDate = expiryDate;
        this.isShippable = isShippable;
    }

    public static void add(String name, double price, int quantity, double weight, 
                         LocalDateTime expiryDate, boolean isShippable) {
        if (products.containsKey(name)) {
            System.out.println("Product already exists");
            return;
        }
        
        Product product = new Product(name, price, quantity, weight, expiryDate, isShippable);
        products.put(name, product);
        System.out.println("Product added successfully");
    }

    public static void remove(String name) {
        if (products.remove(name) != null) {
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    public static void modify(String name, double price, int quantity) {
        Product product = products.get(name);
        if (product == null) {
            System.out.println("Product not found");
            return;
        }
        
        product.price = price;
        product.quantity = quantity;
        System.out.println("Product modified successfully");
    }

    public static Product get(String name) {
        return products.get(name);
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getWeight() { return weight; }
    public boolean isShippable() { return isShippable; }

    public boolean isExpired() {
        return expiryDate != null && 
               LocalDateTime.parse("2025-07-04 20:34:34", formatter).isAfter(expiryDate);
    }
}