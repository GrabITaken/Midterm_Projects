package MidtermProject;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Postfix Expression Evaluator ===");
        System.out.print("Enter postfix expression (space-separated): ");
        String input = sc.nextLine();

        try {
            double result = PostfixEvaluator.evaluate(input);
            System.out.println("\nFinal Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}