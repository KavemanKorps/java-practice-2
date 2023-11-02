package calculator;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// odo: PUT ALL THIS IN A WHILE-DO LOOP.
// unlike post-fix notation, RPN does not reset the stack every time.
public class calculator {
    public static void main(String[] args) throws Exception {
        // STACK
        Stack <Integer> int_stack = new Stack<Integer>();
        int num1, num2;

        System.out.println("Enter input (press h for help):");
        Scanner console = new Scanner(System.in);    
        String input = console.nextLine();        // will contain numbers, operators, and keyletters

        String s = "p print top\n"
                + "n  print top and remove\n"
                + "d  duplicate top\n"
                + "r  exchange top two items\n"
                + "f  print contents of stack\n"
                + "+  add\n"
                + "-  subtract\n"
                + "*  multiply\n"
                + "/  integer divide\n"
                + "%  integer remainder\n"
                + "m  unary minus\n"
                + "q  quit\n";

        do {
            String[] tokens = input.split(" ");

            // each value in the array is a "token"
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i];
                switch (token) {
                    //COMMANDS:
                    case "h":
                        System.out.println(s);
                        break;

                    case "p":
                        // print topmost element
                        System.out.println(int_stack.peek());
                        break;

                    case "n":
                        // print and remove topmost
                        System.out.println(int_stack.pop());
                        break;

                    case "d":
                        // duplicate topmost element
                        int_stack.push(int_stack.peek());
                        break;

                    case "r":
                        // exchange two topmost elements
                        int first = int_stack.pop();
                        int second = int_stack.pop();

                        int_stack.push(first);
                        int_stack.push(second);
                        break;
                        
                    case "f":
                        // print contents of stack
                        System.out.println(Arrays.toString(int_stack.toArray()));
                        break;
                        
                    case "m":
                        // unary minus: turn topmost element into its opposite
                        int top = -int_stack.pop();
                        int_stack.push(top);
                        break;           
                        
                    case "q":
                        System.out.println("quitting program...");
                        break;                  

                    case "+":
                        int_stack.push(int_stack.pop() + int_stack.pop());
                        break;
                    case "-":
                        num1 = int_stack.pop();
                        num2 = int_stack.pop();
                        int_stack.push(num2 - num1);
                        break;
                    case "*":
                        int_stack.push(int_stack.pop() * int_stack.pop());
                        break;
                    case "/":
                        // 3 4 / --> num1 = 3, num2 = 4 
                        num1 = int_stack.pop();
                        num2 = int_stack.pop();
                        int_stack.push(num2 / num1);
                        break;
                    case "%":
                        num1 = int_stack.pop();
                        num2 = int_stack.pop();
                        int_stack.push(num2 % num1);
                        break;
                    // if not an operator, it's an integer
                    default:
                        int_stack.push(Integer.parseInt(token));
                        break;
                }
            }
        } while (input != "q");
        // return int_stack.pop();
        System.out.println(int_stack.pop());
    
        console.close();
    }
}
