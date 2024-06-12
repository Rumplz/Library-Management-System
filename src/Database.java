import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Book> books;
    private List<Student> students;

    public Database() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();

        // database for books and students
        books.add(new Book("1", "Book One", "Author One", "ISBN001"));
        books.add(new Book("2", "Book Two", "Author Two", "ISBN002"));
        books.add(new Book("3", "Book Three", "Author Three", "ISBN003"));
        books.add(new Book("4", "Book Four", "Author Four", "ISBN004"));
        books.add(new Book("5", "Book Five", "Author Five", "ISBN005"));
        books.add(new Book("6", "Book Six", "Author Six", "ISBN006"));
        books.add(new Book("7", "Book Seven", "Author Seven", "ISBN007"));
        books.add(new Book("8", "Book Eight", "Author Eight", "ISBN008"));
        books.add(new Book("9", "Book Nine", "Author Nine", "ISBN009"));
        books.add(new Book("10", "Book Ten", "Author Ten", "ISBN010"));

        //Student ider say add honay
        students.add(new Student("Muhammad Mujtaba", "S001", "student1"));
        students.add(new Student("Ubaid Bhatti", "S002", "student2"));
        students.add(new Student("Student Three", "S003", "student3"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
