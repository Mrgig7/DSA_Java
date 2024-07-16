public class MinimumNumberOfMovesToMakePalindrome {
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && l == 2) {
                    dp[i][j] = 0;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        MinimumNumberOfMovesToMakePalindrome m = new MinimumNumberOfMovesToMakePalindrome();
        System.out.println(m.minMovesToMakePalindrome("abc")); // Output: 2
        System.out.println(m.minMovesToMakePalindrome("letelt")); // Output: 3
        System.out.println(m.minMovesToMakePalindrome("eqvvhtcsaaqtqesvvqch")); // Output: 17
    }
}
