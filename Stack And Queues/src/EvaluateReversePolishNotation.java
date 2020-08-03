import java.util.Scanner;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    private static int evaluate(String[] tokens) {
        int totalTokens = tokens.length;
        if (totalTokens == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < totalTokens; i++) {
            String token = tokens[i];
            if ("+".equals(token)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand1 + operand2);
            } else if ("-".equals(token)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 - operand1);
            } else if ("*".equals(token)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand1 * operand2);
            } else if ("/".equals(token)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(operand2 / operand1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of tokens");
        int totalTokens = scanner.nextInt();
        System.out.println("Enter the tokens");
        String[] tokens = new String[totalTokens];
        for (int i = 0; i < totalTokens; i++) {
            tokens[i] = scanner.next();
        }
        int result = evaluate(tokens);
        System.out.println("Evaluated result of reverse polish notation is: " + result);
    }
}
