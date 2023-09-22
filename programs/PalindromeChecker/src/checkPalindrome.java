import java.util.Arrays;
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

        for (int i = 0; i < string1.length(); i++) {
            arr[i] = string1.charAt(i);
        };
        // System.out.println(string1);

        // STACK:
        Stack <Character> string_stack = new Stack<Character>();

        // QUEUE:
        Queue<Character> string_queue = new LinkedList<Character>();

        for (int i = 0; i < string1.length(); i++) {
            // arr[i] = string1.charAt(i);
            string_stack.add(string1.charAt(i));
            string_queue.add(string1.charAt(i));
        };

        System.out.println(string_stack.toString());
        System.out.println(string_queue.toString());

        // [l, o, l]  -> STACK (FILO): start from right, to left. Keep adding on left. Remove at biggest index. 
        // -----+0
        // [l, o, l]  -> QUEUE (FIFO): start from left, to right. Keep adding on right. Remove from index 0.
        // 0----------+

        // TOPMOST ITEM IN A STACK IS AT THE FAR RIGHT OF IT LOL.

        
        console.close();
    };
};

