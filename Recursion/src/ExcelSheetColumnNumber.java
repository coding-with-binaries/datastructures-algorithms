import java.util.Scanner;

public class ExcelSheetColumnNumber {
    private static int getColumnFromLastCharacter(char ch) {
        return ch - 64;
    }

    private static int getColumnNumber(String title) {
        int len = title.length();
        if (len == 0) {
            return 0;
        }

        char ch = title.charAt(len - 1);
        if (title.length() == 1) {
            return getColumnFromLastCharacter(ch);
        }
        return getColumnFromLastCharacter(ch) + 26 * getColumnNumber(title.substring(0, len - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the column number");
        String columnTitle = scanner.nextLine();
        int column = getColumnNumber(columnTitle);
        System.out.println("Column number is: " + column);
    }
}
