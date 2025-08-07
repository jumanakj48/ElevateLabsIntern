import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<Integer> issuedBookIds;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBookIds = new ArrayList<>();
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public List<Integer> getIssuedBookIds() { return issuedBookIds; }

    public void issueBook(int bookId) {
        issuedBookIds.add(bookId);
    }

    public void returnBook(int bookId) {
        issuedBookIds.remove(Integer.valueOf(bookId));
    }

    @Override
    public String toString() {
        return userId + " - " + name + " | Issued Books: " + issuedBookIds;
    }
}
