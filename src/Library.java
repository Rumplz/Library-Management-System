import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<LibraryItem> items;
    private List<Student> students;

    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    public LibraryItem getItem(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                results.add(item);
            }
        }
        return results;
    }

    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    results.add(book);
                }
            }
        }
        return results;
    }

    public List<LibraryItem> searchByPublisher(String publisher) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                if (magazine.getPublisher().equalsIgnoreCase(publisher)) {
                    results.add(magazine);
                }
            }
        }
        return results;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
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
