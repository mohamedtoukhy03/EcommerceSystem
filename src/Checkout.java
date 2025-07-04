import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Checkout {
    private static final double SHIPPING_RATE = 10.0;
    
    public static void processCheckout(Customer customer) {
        Cart cart = customer.getCart();
        
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }
        
        double subtotal = 0;
        double shippingFees = 0;
        List<Product> shippableItems = new ArrayList<>();
        
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            
            if (quantity > product.getQuantity()) {
                System.out.println("Error: " + product.getName() + " is out of stock");
                return;
            }
            
            if (product.isExpired()) {
                System.out.println("Error: " + product.getName() + " is expired");
                return;
            }
            
            subtotal += product.getPrice() * quantity;
            
            if (product.isShippable()) {
                shippingFees += SHIPPING_RATE * quantity;
                shippableItems.add(product);
            }
            
            product.setQuantity(product.getQuantity() - quantity);
        }
        
        double totalAmount = subtotal + shippingFees;
        
        if (customer.getBalance() < totalAmount) {
            System.out.println("Error: Insufficient balance");
            return;
        }
        
        customer.deductBalance(totalAmount);
        
        printReceipt(cart, subtotal, shippingFees, totalAmount, customer.getBalance());
        
        if (!shippableItems.isEmpty()) {
            printShippingDetails(shippableItems);
        }
        
        cart.clear();
    }
    
    private static void printReceipt(Cart cart, double subtotal, double shippingFees, 
                                   double totalAmount, double remainingBalance) {
        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.printf("%dx %s\t%.2f%n", 
                entry.getValue(), 
                entry.getKey().getName(), 
                entry.getKey().getPrice() * entry.getValue());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.2f%n", subtotal);
        System.out.printf("Shipping\t%.2f%n", shippingFees);
        System.out.printf("Amount\t\t%.2f%n", totalAmount);
        System.out.printf("Balance\t\t%.2f%n", remainingBalance);
    }
    
    private static void printShippingDetails(List<Product> items) {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        
        for (Product item : items) {
            System.out.printf("%s\t%.0fg%n", item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }
        
        System.out.printf("Total package weight %.1fkg%n", totalWeight/1000);
    }
}