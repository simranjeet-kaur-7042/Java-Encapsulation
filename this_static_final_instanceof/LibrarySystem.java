//Create a Book class to manage library books with the following features:
// Static:A static variable libraryName shared across all books.A static method displayLibraryName() to print the library name.
// This:Use this to initialize title, author, and isbn in the constructor.
// Final:Use a final variable isbn to ensure the unique identifier of a book cannot be changed.
// Instanceof:Verify if an object is an instance of the Book class before displaying its details.

class Book{
    static String libraryName="Central Library";
    private String bookTitle;
    private String authorName;
    private double price;
    private final String isbn;
    Book(String bookTitle,String authorName,double price,String isbn){
        this.bookTitle=bookTitle;
        this.authorName=authorName;
        this.price=price;
        this.isbn=isbn;
    }
    public void displayBookDetails(){
        if(this instanceof Book){
            System.out.println("Library: " + libraryName);
         	System.out.println("Book Title: " + bookTitle);
         	System.out.println("Book Author: " + authorName);
            System.out.println("Book Price: " + price);
            System.out.println("ISBN: " + isbn);

        }
    }
    public static void displayLibraryName() {
     	System.out.println("Library Name: " + libraryName);
 	}
}
 public class LibrarySystem {
 	public static void main(String[] args) {
     	Book b1 = new Book( "Java Programming", "RK Singh",900,"978-3-16-148410-0");
     	Book b2 = new Book( "Data Structures", "SP Shukla",1200,"978-0-262-13472-9");

     	b1.displayBookDetails();
     	b2.displayBookDetails();
     	Book.displayLibraryName();
 	}
 }
