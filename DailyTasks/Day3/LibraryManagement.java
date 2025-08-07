import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        // Sample books and users
        library.addBook(new Book(101, "The Alchemist", "Paulo Coelho", "1st"));
        library.addBook(new Book(102, "Atomic Habits", "James Clear", "2nd"));
        library.addUser(new User(1, "Alice"));
        library.addUser(new User(2, "Bob"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- Library Menu ----");
            System.out.println("1. Display Books");
            System.out.println("2. Display Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displayUsers();
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int issueUserId = sc.nextInt();
                    library.issueBook(issueBookId, issueUserId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int returnUserId = sc.nextInt();
                    library.returnBook(returnBookId, returnUserId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
