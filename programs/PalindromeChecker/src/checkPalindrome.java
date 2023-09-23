import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class checkPalindrome {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in); // Read user input
        System.out.println("Enter String:");     // ask user for input
        String string1 = console.nextLine().toLowerCase();

        char[] arr = new char[string1.length()];

        boolean isPali = true;

        for (int i = 0; i < string1.length(); i++) {
            arr[i] = string1.charAt(i);
        };

        // STACK:
        Stack <Character> string_stack = new Stack<Character>();

        // QUEUE:
        Queue<Character> string_queue = new LinkedList<Character>();

        for (int i = 0; i < string1.length(); i++) {
            string_stack.add(string1.charAt(i));
            string_queue.add(string1.charAt(i));
        };

        for (int i = 0; i < string1.length(); i++) {
            // System.out.println(i + " " + string_stack.pop());
            if (string_stack.pop() != string_queue.poll()) {
                isPali = false;
            }
        }

        if (isPali == false) {
            System.out.println(string1 + " is not a palindrome");
        } else {
            System.out.println(string1 + " is a palindrome!");
        }
        // System.out.println(" ");
        // for (int i = 0; i < string1.length(); i++) {
        //     System.out.println(i + " " + string_queue.poll());
        // }

        // System.out.println(string_stack.toString());
        // System.out.println(string_queue.toString());


        // QUEUE METHODS:
        // string_queue.poll() is for removing elements at the front. Also gets the value itself if added to a var
        // string_queue.peek() gets the value without actually removing it. 

        // STACK METHODS:
        // string_stack.pop() is for removing most recently added element (at right).
        // string_stack.peek() gets the value without actually removing it. 


        // [l, o, l]  -> STACK (FILO): start from right, to left. Keep adding on left. Remove at biggest index. 
        // -----+0
        // [l, o, l]  -> QUEUE (FIFO): start from left, to right. Keep adding on right. Remove from index 0.
        // 0----------+

        // TOPMOST ITEM IN A STACK IS AT THE FAR RIGHT OF IT LOL.
        console.close();
    };
};

