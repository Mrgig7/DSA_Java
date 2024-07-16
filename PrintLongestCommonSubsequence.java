import java.util.*;

public class PrintLongestCommonSubsequence {
    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
        int m = a.size();
        int n = b.size();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int x = a.get(i - 1);
                int y = b.get(j - 1);
                if (x == y) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        List<Integer> r = new ArrayList<Integer>();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            int x = a.get(i - 1);
            int y = b.get(j - 1);
            if (x == y) {
                r.add(x);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        Collections.reverse(r);
        return r;

    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> b = Arrays.asList(2, 3, 4, 5, 6);
        
        List<Integer> lcs = longestCommonSubsequence(a, b);
        System.out.println(lcs);
    
    }
}
