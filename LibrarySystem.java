//Use an abstract class LibraryItem with fields like itemId, title, and author.Add an abstract method getLoanDuration() and a concrete method getItemDetails().
// Create subclasses Book, Magazine, and DVD, overriding getLoanDuration() with specific logic.
// Implement an interface Reservable with methods reserveItem() and checkAvailability().
// Apply encapsulation to secure details like the borrower’s personal data.
// Use polymorphism to allow a general LibraryItem reference to manage all items, regardless of type.


interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true; 

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean getAvailability() { return isAvailable; }

    protected void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    public abstract int getLoanDuration();
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Book extends LibraryItem implements Reservable {
    private int loanDurationDays;

    public Book(String itemId, String title, String author, int loanDurationDays) {
        super(itemId, title, author);
        this.loanDurationDays = loanDurationDays;
    }

    @Override
    public int getLoanDuration() {
        return loanDurationDays;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(checkAvailability()) {
            setAvailability(false);
            System.out.println("Book '" + getTitle() + "' reserved by " + borrowerName);
        } else {
            System.out.println("Book '" + getTitle() + "' is currently not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getAvailability();
    }

    @Override
    public String toString() {
        return "Book: " + getItemDetails() + ", Loan Duration: " + getLoanDuration() + " days";
    }
}

class Magazine extends LibraryItem implements Reservable {
    private int loanDurationDays;

    public Magazine(String itemId, String title, String author, int loanDurationDays) {
        super(itemId, title, author);
        this.loanDurationDays = loanDurationDays;
    }

    @Override
    public int getLoanDuration() {
        return loanDurationDays;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(checkAvailability()) {
            setAvailability(false);
            System.out.println("Magazine '" + getTitle() + "' reserved by " + borrowerName);
        } else {
            System.out.println("Magazine '" + getTitle() + "' is currently not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getAvailability();
    }

    @Override
    public String toString() {
        return "Magazine: " + getItemDetails() + ", Loan Duration: " + getLoanDuration() + " days";
    }
}

class DVD extends LibraryItem implements Reservable {
    private int loanDurationDays;

    public DVD(String itemId, String title, String author, int loanDurationDays) {
        super(itemId, title, author);
        this.loanDurationDays = loanDurationDays;
    }

    @Override
    public int getLoanDuration() {
        return loanDurationDays;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if(checkAvailability()) {
            setAvailability(false);
            System.out.println("DVD '" + getTitle() + "' reserved by " + borrowerName);
        } else {
            System.out.println("DVD '" + getTitle() + "' is currently not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return getAvailability();
    }

    @Override
    public String toString() {
        return "DVD: " + getItemDetails() + ", Loan Duration: " + getLoanDuration() + " days";
    }
}

public class LibrarySystem{
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 14),
            new Magazine("M001", "National Geographic", "Various Authors", 7),
            new DVD("D001", "Inception", "Christopher Nolan", 3)
        };
        for(LibraryItem item : items) {
            System.out.println(item);
            if(item instanceof Reservable) {
                Reservable res = (Reservable) item;
                System.out.println("Availability: " + res.checkAvailability());
                res.reserveItem("John Doe");
                System.out.println("Availability after reservation: " + res.checkAvailability());
            }
            System.out.println("----------------------------");
        }
    }
}
