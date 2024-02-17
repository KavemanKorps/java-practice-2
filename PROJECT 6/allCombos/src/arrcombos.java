import java.util.Arrays;

public class arrcombos {
    // get all possible permutations
    public static void perms(int[] arr) {
        System.out.println(Arrays.toString(arr));       // print inital arr

        int i = 0;                                      // initial index
        int[] indices = new int[arr.length];            // new array, same size as "arr"

        while (i < arr.length) {
            if (indices[i] < i) {
                int curr = arr[0];
                if (i % 2 == 0) {
                    arr[0] = arr[i];
                    arr[i] = curr;
                } else {
                    curr = arr[indices[i]];
                    arr[indices[i]] = arr[i];
                    arr[i] = curr;
                }
                System.out.println(Arrays.toString(arr)); // turn arr to str for printing
                indices[i]++;
                i = 0;
            } else {
                indices[i] = 0;
                i++;
            }
        }
    }
}