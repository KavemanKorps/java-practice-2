package calculator;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// unlike post-fix notation, RPN does not reset the stack every time.
public class calculator {
    public static void main(String[] args) throws Exception {
        // STACK
        Stack <Integer> int_stack = new Stack<Integer>();
        int num1, num2;

        System.out.println("Enter input:");
        Scanner console = new Scanner(System.in);               
        String stringOShit = console.nextLine();        // will contain numbers, operators, and keyletters
        String[] tokens = stringOShit.split(" ");

        // each value in the array is a "token"
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    break;
                case "/":
                    break;
                case "-":
                    break;
                case "%":
                    break;
                case "*":
                    break;
                // if not an operator, it's an integer
                default:
                    int_stack.push(Integer.parseInt(token));
                    break;
            }
        }



        System.out.println(Arrays.toString(tokens));
    
        console.close();
    }
}
