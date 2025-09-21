// Create a Product class to manage shopping cart items with the following features:
// Static:A static variable discount shared by all products.A static method updateDiscount() to modify the discount percentage.
// This:Use this to initialize productName, price, and quantity in the constructor.
// Final:Use a final variable productID to ensure each product has a unique identifier that cannot be changed.
// Instanceof:Validate whether an object is an instance of the Product class before processing its details.

class Product {
 	private static double discount = 10.0;
 	private final int productID; 
 	private String productName;
 	private double price;
 	private int quantity;

 	public Product(int productID, String productName, double price, int quantity) {
     	this.productID = productID;
     	this.productName = productName;
     	this.price = price;
     	this.quantity = quantity;
 	}

 	public void displayProductDetails() {
     	if (this instanceof Product) {
         	System.out.println("Product ID: " + productID);
         	System.out.println("Name: " + productName);
         	System.out.println("Price: $" + price);
         	System.out.println("Quantity: " + quantity);
         	System.out.println("Discount: " + discount + "%");
     	}
 	}

 	public static void updateDiscount(double newDiscount) {
     	discount = newDiscount;
 	}
 }

 public class ShoppingCart {
 	public static void main(String[] args) {
     	Product prod1 = new Product(101, "Laptop", 1200, 2);
     	Product prod2 = new Product(102, "Smartphone", 800, 5);

     	prod1.displayProductDetails();
     	prod2.displayProductDetails();
     	Product.updateDiscount(15);
     	System.out.println("New Discount Updated!");
 	}
 }


