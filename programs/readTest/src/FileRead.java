import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class FileRead {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Current folder: " + System.getProperty("user.dir"));
        System.out.println("");
        String newLine = System.getProperty("line.separator");
        System.out.println("Java will look there for the file name you enter" 
        + newLine
        + "unless you enter the full path...");
        System.out.println("");
        File defaultFile = new File("data.txt");

        // THIS REQUIRES YOU TO HAVE "data.txt" file in main project folder.
        System.out.println("Default is " + defaultFile.getAbsolutePath());


        Scanner console = new Scanner(System.in); // Read user input

        System.out.println("Enter file name:");     // ask user for input
        String filename = console.nextLine();

        if (filename.equals("") || filename.equals(" ")) {
            // System.out.println("asshole!");
            filename = "data3.txt";
        }

        File file = new File(filename);
        String absolute = file.getAbsolutePath();

        Scanner readFile = new Scanner(new File(filename)); // Read from file
        int text = readFile.nextInt();         //  read the FIRST integer in the file. 

        double[] numbers = new double[text]; // Declare array "numbers" of type double of size 20

        // I WILL HAVE TO USE "HASNEXTINT()"

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = readFile.nextDouble();
        } 
        // data2.txt 

        System.out.println("The file " + absolute + " has " + numbers.length + " numbers in it");
        System.out.println("");
        System.out.println("The numbers are:");
        System.out.println("");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }


        // int sum = DoubleStream.of(numbers).sum();
        double mean = (Arrays.stream(numbers).sum()) / text;    // this is the mean

        double[] indivs = new double[text];

        for (var i = 0; i < numbers.length; i++) {
            indivs[i] = Math.pow((mean - numbers[i]), 2);
        } 

        // get sum of indivs and divide by 4. Get square root of that.
        double total = Math.sqrt(Arrays.stream(indivs).sum() / text);  // 14 / 4

        // System.out.println(total);
        System.out.println("" + newLine);
        System.out.println("The mean is " + String.format("%.3f", mean));
        System.out.println("The standard deviation is " + String.format("%.3f", total));
        System.out.println("");
        System.out.println("Thanks!");

        console.close();
    }
}