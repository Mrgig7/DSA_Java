import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            nextPermutation(nums);

            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;

        // Step 1: Find the first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            // The array is in descending order, reverse it to get the smallest permutation
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the next larger element to swap with nums[k]
        for (int i = n - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                // Step 3: Swap the elements
                swap(nums, k, i);
                break;
            }
        }

        // Step 4: Reverse the subarray from k + 1 to the end
        reverse(nums, k + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
