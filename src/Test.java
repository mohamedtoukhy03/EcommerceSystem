import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        // Add products
        Product.add("Milk", 100, 5, 400, 
            LocalDateTime.parse("2025-07-11 20:34:34", 
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true);
        Product.add("Phone", 1000, 2, 200, 
            null, true);
        Product.add("Gift Card", 50, 100, 0, 
            null, false);
            
        // Modify a product
        Product.modify("Milk", 120, 10);
        
        // Create customer
        Customer customer = new Customer("John", 5000);
        
        // Add items to cart
        customer.getCart().addProduct("Milk", 2);
        customer.getCart().addProduct("Phone", 1);
        customer.getCart().addProduct("Gift Card", 1);
        
        // Process checkout
        Checkout.processCheckout(customer);
    }
}