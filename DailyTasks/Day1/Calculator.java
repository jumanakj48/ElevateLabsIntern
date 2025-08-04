

public class Calculator {
    
    public static void add(int a, int b) {
        System.out.println("Result: " + (a + b));
    }

    public static void subtract(int a, int b) {
        System.out.println("Result: " + (a - b));
    }

    public static void multiply(int a, int b) {
        System.out.println("Result: " + (a * b));
    }

    public static void divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is undefined.");
        } else {
            System.out.println("Result: " + (a / b));
        }
    }
}
