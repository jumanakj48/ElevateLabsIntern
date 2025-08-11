import java.util.*;



public class MultiAccountATM {

    private static String generateAccountNumber(Set<String> existingAccounts) {
        Random rand = new Random();
        String accNum;
        do {
            accNum = String.format("%08d", rand.nextInt(100000000)); 
        } while (existingAccounts.contains(accNum));
        return accNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();
        boolean exit = false;

        System.out.println("=== Multi-Account ATM Simulation ===");

        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    String accNum = generateAccountNumber(accounts.keySet());
                    sc.nextLine(); 
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = sc.nextDouble();
                    accounts.put(accNum, new Account(accNum, name, initialBalance));
                    System.out.println("Account created successfully!");
                    System.out.println(" Your Account Number is: " + accNum);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    String loginAccNum = sc.nextLine();
                    if (!accounts.containsKey(loginAccNum)) {
                        System.out.println("Account not found.");
                        break;
                    }
                    Account loggedInAccount = accounts.get(loginAccNum);
                    boolean logout = false;

                    while (!logout) {
                        System.out.println("\n--- Account Menu ---");
                        System.out.println("1. Deposit Money");
                        System.out.println("2. Withdraw Money");
                        System.out.println("3. Check Balance");
                        System.out.println("4. View Transaction History");
                        System.out.println("5. Logout");
                        System.out.print("Enter choice: ");
                        int accChoice = sc.nextInt();

                        switch (accChoice) {
                            case 1:
                                System.out.print("Enter deposit amount: ");
                                loggedInAccount.deposit(sc.nextDouble());
                                break;
                            case 2:
                                System.out.print("Enter withdrawal amount: ");
                                loggedInAccount.withdraw(sc.nextDouble());
                                break;
                            case 3:
                                loggedInAccount.checkBalance();
                                break;
                            case 4:
                                loggedInAccount.printTransactionHistory();
                                break;
                            case 5:
                                logout = true;
                                System.out.println("Logged out.");
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
