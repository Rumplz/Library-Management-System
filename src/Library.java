import java.util.ArrayList;
import java.util.List;


public class Library {
    private String name;
    private List<LibraryItem> items;

    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void displayAllItems() {
        for (LibraryItem item : items) {
            item.display();
        }
    }

    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                result.add(item);
            }
        }
        return result;
    }
}
