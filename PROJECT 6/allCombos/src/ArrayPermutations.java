import java.util.Arrays;

public class ArrayPermutations {
    
    public static void printPermutations(int[] arr) {
        int n = arr.length;
        permute(arr, 0, n - 1);
    }

    private static void permute(int[] arr, int left, int right) {
        if (left == right) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                permute(arr, left + 1, right);
                swap(arr, left, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printPermutations(arr);
    }
}
