import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String name;
    private Map<String, LibraryItem> items;
    private List<Student> students;

    public Library(String name) {
        this.name = name;
        this.items = new HashMap<>();
        this.students = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.put(item.getId(), item);
    }

    public LibraryItem getItem(String id) {
        return items.get(id);
    }

    public boolean removeItem(String id) {
        return items.remove(id) != null;
    }

    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items.values()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items.values()) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                result.add(item);
            }
        }
        return result;
    }

    public void displayAllItems() {
        for (LibraryItem item : items.values()) {
            item.display();
        }
    }

    public Book borrowBook(String isbn) {
        LibraryItem item = items.get(isbn);
        if (item instanceof Book) {
            Book book = (Book) item;
            if (book.isAvailable()) {
                book.setAvailable(false);
                return book;
            }
        }
        return null;
    }

    public void returnBook(String isbn) {
        LibraryItem item = items.get(isbn);
        if (item instanceof Book) {
            ((Book) item).setAvailable(true);
        }
    }

    public Book getBook(String isbn) {
        LibraryItem item = items.get(isbn);
        return item instanceof Book ? (Book) item : null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentByPassword(String password) {
        for (Student student : students) {
            if (student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }
}
