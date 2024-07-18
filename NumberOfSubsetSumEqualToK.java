import java.util.*;

public class NumberOfSubsetSumEqualToK {
    public int subsetSum(int[] a, int n, int t) {
        int MOD = 1000000007;
        int[][] dp = new int[n+1][t+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                dp[i][j] = dp[i - 1][j]; 
                if (j >= a[i - 1]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - a[i - 1]]) % MOD;
                }
            }
        }

        return dp[n][t];
    }

    public static void main(String[] args) {
        NumberOfSubsetSumEqualToK solution = new NumberOfSubsetSumEqualToK();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solution.subsetSum(nums, n, k));
    }
}
