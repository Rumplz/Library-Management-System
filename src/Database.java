import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Book> books;

    public Database() {
        books = new ArrayList<>();
        initializeBooks();
    }

    private void initializeBooks() {
        books.add(new Book("How to become rich", "Andrew Tate", "ISBN001"));
        books.add(new Book("How to become poor", "Ubaid Bhatti", "ISBN002"));
        books.add(new Book("Book Title 3", "Author 3", "ISBN003"));
        books.add(new Book("Book Title 4", "Author 4", "ISBN004"));
        books.add(new Book("Book Title 5", "Author 5", "ISBN005"));
        books.add(new Book("Book Title 6", "Author 6", "ISBN006"));
        books.add(new Book("Book Title 7", "Author 7", "ISBN007"));
        books.add(new Book("Book Title 8", "Author 8", "ISBN008"));
        books.add(new Book("Book Title 9", "Author 9", "ISBN009"));
        books.add(new Book("Book Title 10", "Author 10", "ISBN010"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        for (Book book : books) {
            book.display();
        }
    }
}
