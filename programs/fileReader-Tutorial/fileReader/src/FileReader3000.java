import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader3000 {
    public static void main(String[] args) throws FileNotFoundException  {
        File file = new File ("/Users/Juan_jr/Desktop/Coding Shit/NOTES/animationNotes.txt");  
        Scanner scan = new Scanner(file); // read user  

        System.out.println(scan.nextLine());
    }
}