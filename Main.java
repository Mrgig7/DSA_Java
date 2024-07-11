import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[3];
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][k] + a[j]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
    
}
