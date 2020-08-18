import java.util.Scanner;

public class ExcelSheetColumn {
    private static String getLastCharacterOfColumn(int remainder) {
        char lastChar = remainder == 0 ? 'Z' : (char) (remainder + 64);
        return String.valueOf(lastChar);
    }

    private static String getColumnPrefix(int column) {
        int quotient = column / 26;
        int remainder = column % 26;
        if (quotient == 0 || quotient == 1 && remainder == 0) {
            return getLastCharacterOfColumn(remainder);
        }

        return getColumnPrefix(remainder == 0 ? quotient - 1 : quotient) + getLastCharacterOfColumn(remainder);
    }

    private static String getColumnTitle(int column) {
        if (column == 0) {
            return "";
        }
        return getColumnPrefix(column);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the column number");
        int column = scanner.nextInt();
        String columnTitle = getColumnTitle(column);
        System.out.println("Column title is: " + columnTitle);
    }
}
