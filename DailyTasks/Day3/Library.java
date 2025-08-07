import java.util.*;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void issueBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            System.out.println("Invalid Book or User ID.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            book.setIssued(true);
            user.issueBook(bookId);
            System.out.println("Book issued successfully.");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            System.out.println("Invalid Book or User ID.");
            return;
        }

        if (book.isIssued()) {
            book.setIssued(false);
            user.returnBook(bookId);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }

    public void displayBooks() {
        System.out.printf("%-10s %-25s %-15s %-10s %-10s%n", "ID", "Title", "Author", "Edition", "Status");
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }

    public void displayUsers() {
        for (User u : users.values()) {
            System.out.println(u);
        }
    }
}
