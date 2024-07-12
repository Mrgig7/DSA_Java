public class SubsetSum {
    static boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N+1][sum+1];
        for(int i=0; i<=N; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<=sum; i++){
            dp[0][i] = false;
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[N][sum] == true;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(N, arr, sum));
    }
}
