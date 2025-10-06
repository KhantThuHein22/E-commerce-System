import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create products
        Product product_1 = new Product(100, "Shirt", 300);
        Product product_2 = new Product(101, "Pants", 150);
        Product product_3 = new Product(102, "Boots", 100);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product_1);
        products.add(product_2);
        products.add(product_3);
        // Creating customer
        System.out.print("Enter your name: ");
        String customer_Name = scanner.nextLine();
        Customer customer = new Customer(1, customer_Name);
        boolean shopping = true;
        while (shopping) {
            System.out.println("\nAvailable Products:");
            for (Product p : products) {
                System.out.println(p.getProductID() + ". " + p.getName() + " - $" + p.getPrice());
            }
            System.out.println("0. Checkout");
            System.out.print("Enter the product ID to add to cart (or 0 to checkout): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                shopping = false;
            } else {
                boolean found = false;
                for (Product p : products) {
                    if (p.getProductID() == choice) {
                        customer.adding_Product(p);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid product ID. Try again.");
                }
            }
        }
        // Show cart
        System.out.println("\nYour Cart:");
        customer.displaying_Customer();
        // Place order
        Order order = customer.order_placing(1001);
        // Show order details
        if (order != null) {
            System.out.println("\nOrder Details:");
            order.viewing_Order();
        }
        scanner.close();
    }
}
