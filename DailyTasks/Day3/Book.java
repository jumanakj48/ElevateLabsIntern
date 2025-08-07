public class Book {
    private int id;
    private String title;
    private String author;
    private String edition;
    private boolean isIssued;

    public Book(int id, String title, String author, String edition) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getEdition() { return edition; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }

    @Override
    public String toString() {
        return String.format("%-10d %-25s %-15s %-10s %-10s", id, title, author, edition, isIssued ? "Issued" : "Available");
    }
}
