package library;

public class Book {
    int bookId;
    String title;
    String author;
    double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}


import library.Book;

public class Main {
    public static void main(String[] args) {

        Book b = new Book(101, "Java Programming",
                         "James Gosling", 599.00);

        System.out.println("----- Book Details -----");
        b.displayBook();
    }
}
