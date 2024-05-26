//is ko libitem say extend kia to achive abstractionb
public class Book extends LibraryItem {
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        super(title, author);
        this.isbn = isbn;
        this.isAvailable = true;
    }

    @Override
    public void display() {
        System.out.println("Book - Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + isbn);
    }
}
