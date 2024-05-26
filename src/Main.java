import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library = new Library("My Library");
    private static Database database = new Database();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Load initial books from the database into the library
        for (Book book : database.getBooks()) {
            library.addItem(book);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Magazine");
            System.out.println("3. Display All Items");
            System.out.println("4. Search by Title");
            System.out.println("5. Search by Author");
            System.out.println("6. Display Database Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMagazine();
                    break;
                case 3:
                    displayAllItems();
                    break;
                case 4:
                    searchByTitle();
                    break;
                case 5:
                    searchByAuthor();
                    break;
                case 6:
                    displayDatabaseBooks();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        LibraryItem book = new Book(title, author, isbn);
        library.addItem(book);
        System.out.println("Book added successfully.");
    }

    private static void addMagazine() {
        System.out.print("Enter magazine title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter issue number: ");
        int issueNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        LibraryItem magazine = new Magazine(title, author, issueNumber);
        library.addItem(magazine);
        System.out.println("Magazine added successfully.");
    }

    private static void displayAllItems() {
        System.out.println("\n===== Displaying All Items =====");
        library.displayAllItems();
    }

    private static void searchByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        List<LibraryItem> result = library.searchByTitle(title);
        if (result.isEmpty()) {
            System.out.println("No items found with title: " + title);
        } else {
            System.out.println("\n===== Items Found with Title: " + title + " =====");
            for (LibraryItem item : result) {
                item.display();
            }
        }
    }

    private static void searchByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();

        List<LibraryItem> result = library.searchByAuthor(author);
        if (result.isEmpty()) {
            System.out.println("No items found by author: " + author);
        } else {
            System.out.println("\n===== Items Found by Author: " + author + " =====");
            for (LibraryItem item : result) {
                item.display();
            }
        }
    }

    private static void displayDatabaseBooks() {
        System.out.println("\n===== Displaying Database Books =====");
        database.displayBooks();
    }
}
