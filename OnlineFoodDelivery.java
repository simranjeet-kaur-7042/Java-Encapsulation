//Description: Create an online food delivery system:
// Define an abstract class FoodItem with fields like itemName, price, and quantity.
// Add abstract methods calculateTotalPrice() and concrete methods like getItemDetails().
// Extend it into classes VegItem and NonVegItem, overriding calculateTotalPrice() to include additional charges (e.g., for non-veg items).
// Use an interface Discountable with methods applyDiscount() and getDiscountDetails().
// Demonstrate encapsulation to restrict modifications to order details and use polymorphism to handle different types of food items in a single order-processing method.


interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        if(quantity > 0) this.quantity = quantity;
        else System.out.println("Quantity must be positive");
    }
    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        if(percentage > 0 && percentage <= 100)
            discount = getPrice() * getQuantity() * percentage / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "VegItem Discount: " + discount;
    }

    @Override
    public String toString() {
        return "Veg " + getItemDetails() + ", Total Price: " + calculateTotalPrice();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private double extraChargePerItem = 20; 
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + extraChargePerItem) * getQuantity() - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        if(percentage > 0 && percentage <= 100)
            discount = (getPrice() + extraChargePerItem) * getQuantity() * percentage / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discount;
    }

    @Override
    public String toString() {
        return "Non-Veg " + getItemDetails() + ", Total Price: " + calculateTotalPrice();
    }
}

public class OnlineFoodDelivery{
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Butter Masala", 150, 2),
            new NonVegItem("Chicken Biryani", 250, 1),
            new VegItem("Veg Noodles", 120, 3)
        };

        for(FoodItem item : order) {
            if(item instanceof Discountable) {
                Discountable dItem = (Discountable) item;
                dItem.applyDiscount(10); 
                System.out.println(dItem.getDiscountDetails());
            }
        }

        System.out.println("\n--- Order Details ---");
        for(FoodItem item : order) {
            System.out.println(item); 
        }
        double totalOrderCost = 0;
        for(FoodItem item : order) {
            totalOrderCost += item.calculateTotalPrice();
        }
        System.out.println("\nTotal Order Cost: " + totalOrderCost);
    }
}
