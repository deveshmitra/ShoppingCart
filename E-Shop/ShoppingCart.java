import java.util.*;

class Product{
    private String name;
    private double price;
    private int quantity;

public Product(String name,double price,int quantity){
    this.name = name;
    this.price = price;
    this.quantity = quantity;
}

public String getName(){
    return name;
}
public double getPrice(){
    return price;
}
public int getQuantity(){
    return quantity;
}
public double getTotal(){
    return price*quantity;
}
}

abstract class Discount{
    public abstract double applyDiscount(double total,List<Product> products);
}

class FestiveDiscount extends Discount{
    public double applyDiscount(double total, List<Product> products){
        return total * 0.90;
    }
}

class BulkDiscount extends Discount{
    public double applyDiscount(double total, List<Product> products){
        double discountedTotal = 0;
        for (Product p : products) {
            if (p.getQuantity() > 5) {
                discountedTotal += p.getTotal() * 0.80; 
            } else {
                discountedTotal += p.getTotal();
            }
        }
        return discountedTotal;
    }
}

class NoDiscount extends Discount{
    public double applyDiscount(double total, List<Product> products){
        return total;
    }
}

interface Payment{
    void pay(double amount);
}

class CashPayment implements Payment{
    public void pay(double amount){
        System.out.println("\n Payment Mode: Cash");
        System.out.println("======================================");
        System.out.printf("%-25s : ₹%.2f\n","TOTAL AMOUNT PAYABLE",amount);
        System.out.println("Transaction: Successful");
        System.out.println("======================================");
        System.out.println("Thank you for shopping with us!");
    }
}
class UpiPayment implements Payment{
    public void pay(double amount){
        System.out.println("\n Payment Mode: UPI");
        System.out.println("=========================================");
        System.out.printf("%-25s : ₹%.2f\n","TOTAL AMOUNT PAYABLE",amount);
        System.out.println("Transaction: UPI Successful");
        System.out.println("=========================================");
        System.out.println("Thank you for shopping with us!");
    }
}
class CardPayment implements Payment{
    public void pay(double amount){
        System.out.println("\n Payment Mode: Card");
        System.out.println("=========================================");
        System.out.printf("%-25s : ₹%.2f\n","TOTAL AMOUNT PAYABLE",amount);
        System.out.println("Transaction: Approved");
        System.out.println("=========================================");
        System.out.println("Thank you for shopping with us!");
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to E-Shop ===");
        System.out.print("Enter number of products: ");
        int productCount = sc.nextInt();
        sc.nextLine();

        List<Product> cart = new ArrayList<>();

        for (int i=0;i < productCount;i++) {
            System.out.print("Enter product details (name price quantity): ");
            String[] details = sc.nextLine().split(" ");
            String name = details[0];
            double price = Double.parseDouble(details[1]);
            int quantity = Integer.parseInt(details[2]);
            cart.add(new Product(name, price, quantity));
        }
        System.out.print("Enter discount type (festive/bulk/none): ");
        String discountChoice = sc.nextLine().trim().toLowerCase();
        System.out.println("\n=============== ORDER SUMMARY ===============");
        System.out.printf("%-12s | %-7s | %-5s | %-10s\n","Product","Price","Qty","Subtotal");
        System.out.println("---------------------------------------------");
        
        double totalAmount = 0;
        for (Product p : cart) {
            double subtotal = p.getTotal();
            System.out.printf("%-12s | ₹%-6.2f | %-5d | ₹%-9.2f\n",p.getName(),p.getPrice(),p.getQuantity(),subtotal);
            totalAmount += subtotal;
        }
        System.out.println("---------------------------------------------");
        Discount discount;
        if(discountChoice.equals("festive")){
            discount = new FestiveDiscount();
            System.out.println("Festive Discount Applied (10% OFF)");
        }
        else if(discountChoice.equals("bulk")){
            discount = new BulkDiscount();
            System.out.println("Bulk Discount Applied (20% OFF if qty > 5)");
        }
        else{
            discount = new NoDiscount();
            System.out.println("No Discount Applied");
        }

        double finalAmount = discount.applyDiscount(totalAmount, cart);
        System.out.print("Choose payment method (cash/upi/card): ");
        String paymentChoice = sc.nextLine().trim().toLowerCase();

        Payment payment;
        if (paymentChoice.equals("upi")) {
            payment = new UpiPayment();
        }
        else if(paymentChoice.equals("card")){
            payment = new CardPayment();
        }
        else{
            payment = new CashPayment();
        }
        System.out.println("\n============== PAYMENT RECEIPT ==============");
        payment.pay(finalAmount);
        sc.close();
    }
}
