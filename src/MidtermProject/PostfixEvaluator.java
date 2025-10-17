package MidtermProject;

public class PostfixEvaluator {

    public static double evaluate(String expression) {
        LinkedStack stack = new LinkedStack();
        String[] tokens = expression.split(" ");

        System.out.printf("%-10s %-10s %-10s %-10s %-20s%n", "Symbol", "Operand1", "Operand2", "Value", "Stack");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
                System.out.printf("%-10s %-10s %-10s %-10s %-20s%n", token, "", "", "", stack);
            } else if (isOperator(token)) {
                if (stack.isEmpty()) throw new RuntimeException("Invalid expression");
                double b = stack.pop();
                if (stack.isEmpty()) throw new RuntimeException("Invalid expression");
                double a = stack.pop();
                double result = applyOperator(token, a, b);
                stack.push(result);
                System.out.printf("%-10s %-10.2f %-10.2f %-10.2f %-20s%n", token, a, b, result, stack);
            } else {
                throw new RuntimeException("Unknown token: " + token);
            }
        }

        if (stack.isEmpty()) throw new RuntimeException("No result on stack");
        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return "+-*/^$".contains(token);
    }

    private static double applyOperator(String op, double a, double b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "^":
            case "$": return Math.pow(a, b);
            default: throw new RuntimeException("Unsupported operator: " + op);
        }
    }
}