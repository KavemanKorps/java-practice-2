import java.util.Scanner;

public class PaliRecursion {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter text. Type 'end' to terminate program:");

        // while there's input, get the current line and call "generatePali()" on it:
        while (console.hasNextLine()) {
            String textLine = console.nextLine();
            String palindrome = generatePali(textLine);
            System.out.println("\n" + palindrome + "\n");

            if (textLine.equals("end")) break;   
        }
        console.close();
    }
    // recursive helper func. Recursion works by taking the first character. 
    // made static b/c class itself needs to use it.
    static String generatePali(String input) {
        // base case:
        if (input.isEmpty() == true) return "";
        // get first char of string and keep moving it to the end of substring starting at index 1. 
        else {
            char char1 = input.charAt(0);
            return generatePali(input.substring(1)) + char1;
        }
    }
}
