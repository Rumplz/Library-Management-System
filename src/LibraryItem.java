
public abstract class LibraryItem {
    private String title;
    private String author;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract void display();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
