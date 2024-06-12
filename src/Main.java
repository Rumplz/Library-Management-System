import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library = new Library("My Library");
    private static Database database = new Database();
    private static Scanner scanner = new Scanner(System.in);
    private static Admin admin = new Admin("Admin", "A001");

    public static void main(String[] args) {
        // Add initial books and students from the database into the library
        for (Book book : database.getBooks()) {
            library.addItem(book);
        }

        for (Student student : database.getStudents()) {
            library.addStudent(student);
        }

        // Simulate borrowing books and creating fines
        Book book1 = (Book) library.getItem("1");
        Student student1 = library.getStudentById("S001");
        if (student1 != null) {
            student1.borrowBook(book1);
            student1.addFine(50); // Add fine manually
        }

        Book book2 = (Book) library.getItem("2");
        Student student2 = library.getStudentById("S002");
        if (student2 != null) {
            student2.borrowBook(book2);
            student2.addFine(50); // Add fine manually
        }

        login();
    }

    private static void login() {
        boolean authenticated = false;

        while (!authenticated) {
            System.out.println("\n===== Library Management System Login =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Accounts Login");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (adminLogin()) {
                        authenticated = true;
                        adminPanel();
                    } else {
                        System.out.println("Invalid admin credentials. Try again.");
                    }
                    break;
                case 2:
                    if (studentLogin()) {
                        authenticated = true;
                    } else {
                        System.out.println("Invalid student credentials. Try again.");
                    }
                    break;
                case 3:
                    if (accountsLogin()) {
                        authenticated = true;
                        accountsPanel();
                    } else {
                        System.out.println("Invalid accounts credentials. Try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static boolean adminLogin() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();
        return password.equals("admin");
    }

    private static boolean studentLogin() {
        System.out.print("Enter student password: ");
        String password = scanner.nextLine();
        Student student = library.getStudentByPassword(password);
        if (student != null) {
            studentPanel(student);
            return true;
        }
        return false;
    }

    private static boolean accountsLogin() {
        System.out.print("Enter accounts password: ");
        String password = scanner.nextLine();
        return password.equals("accounts");
    }

    private static void adminPanel() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Admin Panel =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Edit Book");
            System.out.println("4. Add Magazine");
            System.out.println("5. Remove Magazine");
            System.out.println("6. Edit Magazine");
            System.out.println("7. Search Book by Title");
            System.out.println("8. Search Book by Author");
            System.out.println("9. Search Magazine by Publisher");
            System.out.println("10. Add Fine to Student");
            System.out.println("11. Remove Fine from Student");
            System.out.println("12. Add Student");
            System.out.println("13. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    addMagazine();
                    break;
                case 5:
                    removeMagazine();
                    break;
                case 6:
                    editMagazine();
                    break;
                case 7:
                    searchByTitle();
                    break;
                case 8:
                    searchByAuthor();
                    break;
                case 9:
                    searchByPublisher();
                    break;
                case 10:
                    addFine();
                    break;
                case 11:
                    removeFine();
                    break;
                case 12:
                    addStudent();
                    break;
                case 13:
                    exit = true;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void studentPanel(Student student) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Student Panel =====");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Account Details");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    borrowBook(student);
                    break;
                case 2:
                    returnBook(student);
                    break;
                case 3:
                    displayStudentAccount(student);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void accountsPanel() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Accounts Panel =====");
            System.out.println("1. View All Fines");
            System.out.println("2. View All Borrowed Books");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayOverdueFines();
                    break;
                case 2:
                    displayBorrowedBooks();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(id, title, author, isbn);
        library.addItem(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.print("Enter book ID to remove: ");
        String id = scanner.nextLine();
        library.removeItem(id);
        System.out.println("Book removed successfully.");
    }

    private static void editBook() {
        System.out.print("Enter book ID to edit: ");
        String id = scanner.nextLine();

        Book book = (Book) library.getItem(id);
        if (book != null) {
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new author: ");
            String author = scanner.nextLine();
            System.out.print("Enter new ISBN: ");
            String isbn = scanner.nextLine();

            book.setTitle(title);
            book.setAuthor(author);
            book.setIsbn(isbn);

            System.out.println("Book edited successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void addMagazine() {
        System.out.print("Enter magazine ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter magazine title: ");
        String title = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter issue number: ");
        int issueNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Magazine magazine = new Magazine(id, title, publisher, issueNumber);
        library.addItem(magazine);
        System.out.println("Magazine added successfully.");
    }

    private static void removeMagazine() {
        System.out.print("Enter magazine ID to remove: ");
        String id = scanner.nextLine();
        library.removeItem(id);
        System.out.println("Magazine removed successfully.");
    }

    private static void editMagazine() {
        System.out.print("Enter magazine ID to edit: ");
        String id = scanner.nextLine();

        Magazine magazine = (Magazine) library.getItem(id);
        if (magazine != null) {
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new publisher: ");
            String publisher = scanner.nextLine();
            System.out.print("Enter new issue number: ");
            int issueNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            magazine.setTitle(title);
            magazine.setPublisher(publisher);
            magazine.setIssueNumber(issueNumber);

            System.out.println("Magazine edited successfully.");
        } else {
            System.out.println("Magazine not found.");
        }
    }

    private static void searchByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        List<LibraryItem> results = library.searchByTitle(title);
        for (LibraryItem item : results) {
            System.out.println(item);
        }
    }

    private static void searchByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();

        List<LibraryItem> results = library.searchByAuthor(author);
        for (LibraryItem item : results) {
            System.out.println(item);
        }
    }

    private static void searchByPublisher() {
        System.out.print("Enter publisher to search: ");
        String publisher = scanner.nextLine();

        List<LibraryItem> results = library.searchByPublisher(publisher);
        for (LibraryItem item : results) {
            System.out.println(item);
        }
    }

    private static void addFine() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = library.getStudentById(studentId);
        if (student != null) {
            System.out.print("Enter fine amount: ");
            double fine = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            student.addFine(fine);
            System.out.println("Fine added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeFine() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = library.getStudentById(studentId);
        if (student != null) {
            System.out.print("Enter fine amount to remove: ");
            double fine = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            student.removeFine(fine);
            System.out.println("Fine removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student password: ");
        String password = scanner.nextLine();

        Student student = new Student(name, id, password);
        library.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void displayStudentAccount(Student student) {
        System.out.println("Account details for " + student.getName() + ":");
        System.out.println("Borrowed books:");
        for (Book book : student.getBorrowedBooks()) {
            System.out.println(book);
        }
        System.out.println("Total fine: $" + student.getFine());
    }

    private static void displayOverdueFines() {
        for (Student student : library.getStudents()) {
            System.out.println(student.getName() + " has a fine of $" + student.getFine());
        }
    }

    private static void displayBorrowedBooks() {
        for (Student student : library.getStudents()) {
            System.out.println("Books borrowed by " + student.getName() + ":");
            for (Book book : student.getBorrowedBooks()) {
                System.out.println(book);
            }
        }
    }

    private static void borrowBook(Student student) {
        System.out.print("Enter book ID to borrow: ");
        String bookId = scanner.nextLine();

        Book book = (Book) library.getItem(bookId);
        if (book != null) {
            student.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void returnBook(Student student) {
        System.out.print("Enter book ID to return: ");
        String bookId = scanner.nextLine();

        Book book = (Book) library.getItem(bookId);
        if (book != null) {
            student.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}
