import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter input:");
        Scanner console = new Scanner(System.in);

        // will contain numbers, operators, and keyletters:
        String stringOShit = console.nextLine();

        String[] stringArr = stringOShit.split(" ");

        // STACK
        Stack <Integer> int_stack = new Stack<Integer>();

        System.out.println(Arrays.toString(stringArr));

        String currOperator; 
        String command;

        // each space-seperated value in the string is a "token"
        for (int i = 0; i < stringArr.length; i++) {
            // push integers to the stack, ignoring the operators and set the operator (if given) to currOperator
            // set given command to "command" (if given)
        }
    
        console.close();
    }
}
