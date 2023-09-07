import java.io.*; // for File
import java.util.*; // for Scanner

public class ReadFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(new File("data.txt"));
        // String text = input.next(); <--- only reads first word
        String text = input.nextLine();
        System.out.println(text);
    };
};