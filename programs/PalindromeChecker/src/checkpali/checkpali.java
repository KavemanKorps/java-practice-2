package checkpali;

// import all the needed modules:
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class checkpali {
    public void runcode() {
        // Read user input
        Scanner console = new Scanner(System.in);                           
        System.out.println("Enter String:");               
        
        // save user input in variable
        String string2 = console.nextLine();
        String string1 = string2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();                  

        // check if input is empty string or not:
        if (string1 == "" || string1 == " ") {
            System.out.println("Goodbye!");
        } else {

            // variable to determine if string is palindrome or not
            boolean isPali = true;

            // STACK:
            Stack <Character> string_stack = new Stack<Character>();

            // QUEUE:
            Queue<Character> string_queue = new LinkedList<Character>();

            // add all the characters in the string to the stack and queue:
            for (int i = 0; i < string1.length(); i++) {
                string_stack.add(string1.charAt(i));
                string_queue.add(string1.charAt(i));
            };

            // compare the frontmost element in the queue with the backmost element in the stack.
            // if they are false at any point, then set "isPali" to false.
            for (int i = 0; i < string1.length(); i++) {
                if (string_stack.pop() != string_queue.poll()) {
                    isPali = false;
                }
            }

            // print string telling user if the string is palindrome or not, depending on "isPali"'s value:
            if (isPali == false) {
                System.out.println(string2 + " is not a palindrome");
            } else {
                System.out.println(string2 + " is a palindrome!");
            }
        }

        // close the console Scanner object:
        console.close();
    };
};

        // [l, o, l]  -> STACK (FILO): start from right, to left. Keep adding on left. Remove at biggest index. 
        // -----+0
        // [l, o, l]  -> QUEUE (FIFO): start from left, to right. Keep adding on right. Remove from index 0.
        // 0----------+
