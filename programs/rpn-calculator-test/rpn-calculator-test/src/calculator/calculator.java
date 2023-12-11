package calculator;
import java.util.Stack;
import java.util.Scanner;

public class calculator {
    // public static void main(String[] args) {
    public void runCalc() {
        // MAIN FUNCTION: handles the commands and runs "mathHandler()" to handle numbers/operators 
        Stack<Integer> num_stack = new Stack<>();
        Scanner console = new Scanner(System.in);

        String help = "\np print top\n"
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
        
        System.out.println("Enter input ('q' to quit, 'h' for help):");

        while (true) {
            String input = console.nextLine();

            // Can't use switch statement here. Need "break" to break out of loop.
            // BASE CASE:
            if (input.equals("q")) {
                System.out.println("program terminated");
                break;
            } 
            // COMMANDS:
            else if (input.equals("h")) {
                System.out.println(help);
            }
            else if (input.equals("p")) {
                System.out.println(num_stack.peek());    
            } 
            else if (input.equals("n")) {
                System.out.println(num_stack.pop());
            } 
            else if (input.equals("d")) {
                // Integer top = num_stack.pop();
                Integer top = num_stack.peek();
                num_stack.push(top);
                System.out.println(top);               
            } 
            else if (input.equals("r")) {
                // num_stack.push(num_stack.pop());
                // num_stack.push(num_stack.pop());  

                Integer num1 = num_stack.pop();
                Integer num2 = num_stack.pop();
                num_stack.push(num1);
                num_stack.push(num2);  
            } 
            else if (input.equals("f")) {
                System.out.println(num_stack);
            } 
            else if (input.equals("m")) {
                Integer num1 = num_stack.pop();
                num_stack.push(-num1);
            }
            else {
                // otherwise, we get operators and operands:
                String[] tokens = input.split(" ");
                
                for (int i = 0; i < tokens.length; i++) {
                    // is either a num or operator:
                    String current = tokens[i];

                    // regex to get integer as a string:
                    if (current.matches("-?\\d+")) {
                        num_stack.push(Integer.parseInt(current));    // HOW TO TURN STR TO INT  
                    } else {
                        mathHandler(num_stack, current);
                    }
                }
            }
        }
        console.close();
    }

    // takes stack and operator as arguments:
    private static void mathHandler(Stack<Integer> stack, String operator) {
        
        // get two topmost elements in stack:
        Integer int2 = stack.pop();     // 2nd topmost
        Integer int1 = stack.pop();     // topmost

        // REVIEW: THE PROFESSOR DOES ALL THE POPPING HERE FOR EACH INDIVIDUAL CASE:
        // op2 = (stack.pop()).intValue()
        // op1 = (stack.pop()).intValue()
        // result = op1 + op2;
        // break;
        switch (operator) {
            case "+":
                stack.push(int1 + int2);
                break;
            case "-":
                stack.push(int1 - int2);    
                break;
            case "*":
                stack.push(int1 * int2);
                break;
            case "/":
                stack.push(int1 / int2);   
                break;
            case "%":
                if (int2 != 0) {
                    stack.push(int1 % int2);
                } 
                break;
            // case "m":
            //     stack.push(-a);
            //     break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
