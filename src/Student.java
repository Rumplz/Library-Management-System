import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Book> borrowedBooks;
    private double fine;
    private String password;

    public Student(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
        this.fine = 0.0;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public double getFine() {
        return fine;
    }

    public String getPassword() {
        return password;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void addFine(double amount) {
        fine += amount;
    }

    public void removeFine(double amount) {
        fine -= amount;
        if (fine < 0) {
            fine = 0;
        }
    }
}
// fien