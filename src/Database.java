import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Book> books;

    public Database() {
        books = new ArrayList<>();
        books.add(new Book("Book One", "Author One", "1"));
        books.add(new Book("Book Two", "Author Two", "2"));
        books.add(new Book("Book Three", "Author Three", "3"));
        books.add(new Book("Book Four", "Author Four", "4"));
        books.add(new Book("Book Five", "Author Five", "5"));
        books.add(new Book("Book Six", "Author Six", "6"));
        books.add(new Book("Book Seven", "Author Seven", "7"));
        books.add(new Book("Book Eight", "Author Eight", "8"));
        books.add(new Book("Book Nine", "Author Nine", "9"));
        books.add(new Book("Book Ten", "Author Ten", "10"));
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
