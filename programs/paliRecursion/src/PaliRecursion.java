import java.util.Scanner;

public class PaliRecursion {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter text. Press Ctrl+D to stop:");

        // while there's input, get the current line and call "generatePali()" on it.
        while (console.hasNextLine()) {
            String textLine = console.nextLine();
            String palindrome = generatePali(textLine);
            System.out.println("\n" + palindrome + "\n");
        }
        console.close();
    }
    // recursive func. Recursion works by taking the first character.
    private static String generatePali(String input) {
        // base case:
        if (input.isEmpty()) return "";
        else {
            char charOne = input.charAt(0);
            return generatePali(input.substring(1)) + charOne;
        }
    }
}
