import java.util.Scanner;

public class SubarraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] result = findSubarrayToSort(arr);
            System.out.println(result[0] + " " + result[1]);
        }

        sc.close();
    }

    private static int[] findSubarrayToSort(int[] arr) {
        int n = arr.length;
        int start = -1;
        int end = -1;

        // Step 1: Find the first out-of-order element from the left
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                start = i;
                break;
            }
        }

        // If no such element is found, the array is already sorted
        if (start == -1) {
            return new int[]{0, 0};
        }

        // Step 2: Find the first out-of-order element from the right
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                end = i;
                break;
            }
        }

        // Step 3: Find the minimum and maximum in the subarray arr[start...end]
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Step 4: Expand the subarray to include any elements out of place
        while (start > 0 && arr[start - 1] > min) {
            start--;
        }
        while (end < n - 1 && arr[end + 1] < max) {
            end++;
        }

        return new int[]{start, end};
    }
}
