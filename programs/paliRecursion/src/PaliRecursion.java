import java.util.Scanner;

public class PaliRecursion {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter text, or 'end' to stop:");

        // while there's input, get the current line and call "generatePali()" on it:
        while (console.hasNextLine()) {
            String currLine = console.nextLine();
            String pali = generatePali(currLine);
            System.out.println("\n" + pali + "\n");
            // System.out.println("\n");

            if (currLine.equals("end")) break;   
        }
        console.close();
    }
    // recursive helper func. Recursion works by taking the first character of str. and 
    // then adding it to the back.
    // made static b/c class itself needs to use it.
    static String generatePali(String word) {
        // base case:
        if (word.isEmpty() == true) return " ";
        // get first char of string and keep moving it to the end of substring starting at index 1. 
        else {
            char char1 = word.charAt(0);
            String subStr = word.substring(1);
            return generatePali(subStr) + char1;
        }
    }
}