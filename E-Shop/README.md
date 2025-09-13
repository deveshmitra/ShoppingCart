# E-Shop (Shopping Cart System)

A simple **Java console-based shopping cart system** with support for multiple discounts and payment methods. This project demonstrates **OOP principles** like abstraction, inheritance, polymorphism, and interfaces in a real-world scenario.

## Features
- Add multiple products with: **Name, Price, Quantity**
- Automatic **order summary** with subtotals and grand total
- Supports **discount strategies**:
  -  Festive Discount → 10% OFF on total
  -  Bulk Discount → 20% OFF on items with quantity > 5
  -  No Discount
- Multiple **payment methods**:
  - Cash
  - UPI
  - Card
- Clean formatted **billing receipt**

## How It Works
1. User enters the number of products.  
2. For each product, enter details in the format:  
   `<name> <price> <quantity>`  
3. Choose discount type: `festive / bulk / none`  
4. Review the **order summary**.  
5. Choose payment method: `cash / upi / card`  
6. System prints the **final receipt**.

## Example Run
=== Welcome to E-Shop ===
Enter number of products: 2
Enter product details (name price quantity): Laptop 50000 1
Enter product details (name price quantity): Mouse 500 6
Enter discount type (festive/bulk/none): bulk

=============== ORDER SUMMARY ===============
Product | Price | Qty | Subtotal
Laptop | ₹50000.00 | 1 | ₹50000.00
Mouse | ₹500.00 | 6 | ₹3000.00

Bulk Discount Applied (20% OFF if qty > 5)

Choose payment method (cash/upi/card): upi

============== PAYMENT RECEIPT ==============
Payment Mode: UPI
TOTAL AMOUNT PAYABLE : ₹52400.00
Transaction: UPI Successful

Thank you for shopping with us


## Technologies Used
- **Java** (Core OOP concepts)  
- **Scanner** for user input  
- **Collections Framework** (`List`, `ArrayList`)

## How to Run
1. Clone or download this repository.  
2. Navigate to the project folder.  
3. Compile the program:  
   `javac E_Shop/ShoppingCart.java`  
4. Run the program:  
   `java E_Shop.ShoppingCart`

## Future Improvements
- Add **coupon codes**  
- Implement **database support** for persistent products  
- GUI version with **JavaFX or Swing**  
- Add **tax calculations & shipping charges**
