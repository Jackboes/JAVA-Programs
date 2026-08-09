class LibraryBook {

    final String ISBN;
    String title;
    String author;
    double price;

    LibraryBook(String ISBN, String title, String author, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBook() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {

        LibraryBook book = new LibraryBook(
            "978-0134685991",
            "Effective Java",
            "Joshua Bloch",
            850
        );

        book.displayBook();

        // book.ISBN = "12345";
        // Error: cannot assign a value to final variable
    }
}
