import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class ValidBrackets {
    private static boolean isValid(String exp) {
        Stack<Character> stack = new Stack<>();
        int len = exp.length();
        for (int i = 0; i < len; i++) {
            char ch = exp.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                try {
                    char poppedChar = stack.pop();
                    if (ch == ')' && poppedChar != '(' || ch == '}' && poppedChar != '{' || ch == ']' && poppedChar != '[') {
                        return false;
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression");
        String exp = scanner.nextLine();
        boolean valid = isValid(exp);
        System.out.println(String.format("The expression '%s' %s valid", exp, valid ? "IS" : "IS NOT"));
    }
}
