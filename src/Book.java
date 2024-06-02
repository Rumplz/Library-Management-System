import java.time.LocalDate;

public class Book extends LibraryItem {
    private boolean available;
    private LocalDate borrowedDate;

    public Book(String title, String author, String isbn) {
        super(title, author, isbn);
        this.available = true;
        this.borrowedDate = null;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    @Override
    public void display() {
        System.out.println("Book: " + getTitle() + " by " + getAuthor() + " (ISBN: " + getId() + ")");
    }
}
