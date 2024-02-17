import java.util.Arrays;

public class arrcombos {
    // get all possible permutations
    public static void perms(int[] arr) {
        System.out.println(Arrays.toString(arr));       // print inital arr

        int i = 0;                                      // initial index
        int[] newArr = new int[arr.length];            // new array, same size as "arr"

        while (i < arr.length) {
            if (newArr[i] < i) {
                int curr = arr[0];  // to be overwritten
                // SWAP the elements:
                if (i % 2 == 0) {       // if even 
                    // arr[0] = curr
                    // put at beginning of arr
                    arr[0] = arr[i];
                    arr[i] = curr;
                } else {
                    curr = arr[newArr[i]];
                    arr[newArr[i]] = arr[i];
                    arr[i] = curr;
                }
                System.out.println(Arrays.toString(arr)); // turn arr to str for printing
                newArr[i]++;
                // permutation done, reset:
                i = 0;
            } else {
                newArr[i] = 0;
                i++;
            }
        }
    }
}