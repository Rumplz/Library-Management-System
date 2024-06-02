public class Magazine extends LibraryItem {
    public Magazine(String title, String author, String issueNumber) {
        super(title, author, issueNumber);
    }

    @Override
    public void display() {
        System.out.println("Magazine: " + getTitle() + " by " + getAuthor() + " (Issue Number: " + getId() + ")");
    }
}
