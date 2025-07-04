# E-commerce System

A simple Java-based e-commerce system that handles products, shopping cart, and checkout functionality.

## Overview
The system manages products with various attributes including expiry dates and shipping requirements. It supports basic e-commerce operations like adding products to cart and checkout process with shipping calculations.

## Features
- Product Management
  - Add/Remove/Modify products
  - Handle expirable and non-expirable products
  - Track product quantities
  - Support for shippable and non-shippable items

- Shopping Cart
  - Add products with quantity checks
  - Prevent adding out-of-stock items
  - Handle multiple items

- Checkout System
  - Calculate subtotal and shipping fees
  - Verify customer balance
  - Check product expiry
  - Generate detailed receipts
  - Process shipping for applicable items

## Usage Example

```java
// Add products
Product.add("Milk", 100, 5, 400, 
    LocalDateTime.parse("2025-07-11 20:39:32", 
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true);
Product.add("Phone", 1000, 2, 200, null, true);
Product.add("Gift Card", 50, 100, 0, null, false);

// Create customer
Customer customer = new Customer("John", 5000);

// Add items to cart
customer.getCart().addProduct("Milk", 2);
customer.getCart().addProduct("Phone", 1);
customer.getCart().addProduct("Gift Card", 1);

// Process checkout
Checkout.processCheckout(customer);
```

## Sample Output
```
Product added successfully
Product added successfully
Product added successfully
Product modified successfully
Product added to cart
Product added to cart
Product added to cart

** Checkout receipt **
2x Milk        240.00
1x Phone       1000.00
1x Gift Card   50.00
----------------------
Subtotal       1290.00
Shipping       30.00
Amount         1320.00
Balance        3680.00

** Shipment notice **
Milk    400g
Phone   200g
Total package weight 0.6kg
```

## Class Structure
- `Product.java`: Handles product management and inventory
- `Cart.java`: Manages shopping cart operations
- `Customer.java`: Contains customer information and balance
- `Checkout.java`: Processes orders and generates receipts

## Requirements
- Java 8 or higher
- No additional dependencies required

## Features to be Added
- Database integration
- User authentication
- Order history
- Product categories
- Payment gateway integration
