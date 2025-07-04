import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();
    
    public void addProduct(String productName, int quantity) {
        Product product = Product.get(productName);
        
        if (product == null) {
            System.out.println("Product not found");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Quantity must be positive");
            return;
        }
        
        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock available");
            return;
        }
        
        items.put(product, quantity);
        System.out.println("Product added to cart");
    }
    
    public Map<Product, Integer> getItems() {
        return items;
    }
    
    public void clear() {
        items.clear();
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
}