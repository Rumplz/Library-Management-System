
public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String author, int issueNumber) {
        super(title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public void display() {
        System.out.println("Magazine - Title: " + getTitle() + ", Author: " + getAuthor() + ", Issue Number: " + issueNumber);
    }
}
