import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Book> books;

    public Database() {
        books = new ArrayList<>();
        // Adding 10 books to the database
        books.add(new Book("1", "Book Title 1", "Author 1", "ISBN001"));
        books.add(new Book("2", "Book Title 2", "Author 2", "ISBN002"));
        books.add(new Book("3", "Book Title 3", "Author 3", "ISBN003"));
        books.add(new Book("4", "Book Title 4", "Author 4", "ISBN004"));
        books.add(new Book("5", "Book Title 5", "Author 5", "ISBN005"));
        books.add(new Book("6", "Book Title 6", "Author 6", "ISBN006"));
        books.add(new Book("7", "Book Title 7", "Author 7", "ISBN007"));
        books.add(new Book("8", "Book Title 8", "Author 8", "ISBN008"));
        books.add(new Book("9", "Book Title 9", "Author 9", "ISBN009"));
        books.add(new Book("10", "Book Title 10", "Author 10", "ISBN010"));
    }

    public List<Book> getBooks() {
        return books;
    }
}
