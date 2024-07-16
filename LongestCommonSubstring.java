public class LongestCommonSubstring{
    public static void longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int ml = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(S1.charAt(i-1) == S2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ml = Math.max(ml, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        // return ml;

        for(int i = 0; i <n;i++){
            for(int j = 0; j < m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String S1 = "abcdxyz";
        String S2 = "xyzabcds";
        int n = S1.length();
        int m = S2.length();
        // System.out.println( lcs.longestCommonSubstr(S1, S2, n, m));
        lcs.longestCommonSubstr(S1, S2, n, m);
    }
}