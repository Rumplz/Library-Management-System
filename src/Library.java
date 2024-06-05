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
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Book && ((Book) item).getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Student getStudentByPassword(String password) {
        return students.stream()
                .filter(student -> student.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudents() {
        return students;
    }
}
