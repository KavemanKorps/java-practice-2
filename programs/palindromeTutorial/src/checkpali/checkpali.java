package checkpali;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class checkpali {
    public void runcode() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter String");

        String string1 = console.nextLine();
        String string2 = string1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (string2 == "" || string2 == " ") {
            System.out.println("Goodbye!");
        } else {

            boolean isPali = true;

            Stack <Character> string_stack = new Stack<Character>();

            Queue<Character> string_queue = new LinkedList<Character>();

            for (int i = 0; i < string2.length(); i++) {
                string_stack.add(string2.charAt(i));
                string_queue.add(string2.charAt(i));
            }

            for (int i = 0; i < string2.length(); i++) {
                if (string_stack.pop() != string_queue.poll()) {
                    isPali = false;
                }
            }

            if (isPali == false) {
                System.out.println(string1 + " is not a palindrome");
            } else {
                System.out.println(string1 + " is a palindrome!");
            }
        }
        console.close();
    }
}
