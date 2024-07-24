import java.util.*;

public class SortTheJumbledNumbers {
    private int gm(int n, int[] mapping) {
        if (n == 0) {
            return mapping[0];
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int d = n % 10;
            sb.insert(0, mapping[d]);
            n /= 10;
        }
        return Integer.parseInt(sb.toString());
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int len = nums.length;
        int[][] li = new int[len][2];

        for (int i = 0; i < len; i++) {
            li[i][0] = nums[i];
            li[i][1] = gm(nums[i], mapping);
        }

        Arrays.sort(li, Comparator.comparingInt(a -> a[1]));

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = li[i][0];
        }

        return res;
    }

    public static void main(String[] args) {
        SortTheJumbledNumbers solution = new SortTheJumbledNumbers();
        int[] mapping = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {0, 999999999};
        int[] result = solution.sortJumbled(mapping, nums);
        System.out.println(Arrays.toString(result));
    }
}
