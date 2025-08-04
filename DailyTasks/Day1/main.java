import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;

        while (true) {
            System.out.println("\n------Calculator-------");
            System.out.println("Enter your choice:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    b = sc.nextInt();
                    Calculator.add(a, b);
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    b = sc.nextInt();
                    Calculator.subtract(a, b);
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    b = sc.nextInt();
                    Calculator.multiply(a, b);
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    b = sc.nextInt();
                    Calculator.divide(a, b);
                    break;

                case 5: sc.close();
                         System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }

        
    }
}
