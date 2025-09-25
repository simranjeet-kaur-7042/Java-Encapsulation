//Create an abstract class Product with fields like productId, name, and price, and an abstract method calculateDiscount().
// Extend it into concrete classes: Electronics, Clothing, and Groceries.
// Implement an interface Taxable with methods calculateTax() and getTaxDetails() for applicable product categories.
// Use encapsulation to protect product details, allowing updates only through setter methods.
// Showcase polymorphism by creating a method that calculates and prints the final price (price + tax - discount) for a list of Product.

abstract class Product{
    private int productId;
    private String name;
    private double price;

    public Product(int productId,String name,double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }

    public int getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double p) {
        price = p;
    }
    public void setName(String n) {
        this.name = n;
    }
    abstract double calculateDiscount();
    abstract void printDetails();
}
interface Taxable{
    double calculateTax();
    String getTaxDetails();
}
class Electronics extends Product implements Taxable{
    private int warrentyYears;
    public Electronics(int productId, String name, double price,int warrentyYears) {
        super(productId, name, price);
        this.warrentyYears=warrentyYears;
    }

    public int getWarrentyYears(){
        return warrentyYears;
    }

    double calculateDiscount(){
        return getPrice()*0.10;
    }

    public double calculateTax(){
        return getPrice()*0.18;
    }

    public String getTaxDetails(){
        return "Electronics Tax : 18% GST";
    }
    @Override
    void printDetails() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = getPrice() + tax - discount;

        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Warranty: " + warrentyYears + " years");
        System.out.println("Base Price: " + getPrice());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax + " (" + getTaxDetails() + ")");
        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------");
    }


}
class Clothing extends Product implements Taxable{
    private String size;
    public Clothing(int productId,String name,double price,String size){
        super(productId,name,price);
        this.size=size;
    }
    public String getSize(){
         return size;
    }
    double calculateDiscount() {
        return getPrice() * 0.20; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; 
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5% VAT";
    }

        @Override
    void printDetails() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = getPrice() + tax - discount;

        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Size: " + size);
        System.out.println("Base Price: " + getPrice());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax + " (" + getTaxDetails() + ")");
        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------");
    }
}

class Groceries extends Product implements Taxable {
    private String expiryDate;

    public Groceries(int productId, String name, double price, String expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.02; // 2% VAT
    }

    @Override
    public String getTaxDetails() {
        return "Groceries Tax: 2% VAT";
    }

    @Override
    void printDetails() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = getPrice() + tax - discount;

        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Base Price: " + getPrice());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax + " (" + getTaxDetails() + ")");
        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------");
    }
}

class ProductDetails{
    public static void main(String args[]){
        Product p1 = new Electronics(101, "Laptop", 50000, 2);
        Product p2 = new Clothing(102, "T-Shirt", 2000, "M");
        Product p3 = new Groceries(103, "Rice", 1000, "2026-01-01");

        Product[] products = {p1, p2, p3};

        for (Product p : products) {
            p.printDetails(); 
        }
    }
}
