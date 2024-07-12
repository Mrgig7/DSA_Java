class MinFaillingPathSum {
    public int minFaillingPathSum(int[][] grid) {
        int n = grid.length;
        int mi = Integer.MAX_VALUE;
        int[][] dp = new int[n][n]; 
        for (int c = 0; c < n; c++) {
            mi = Math.min(mi, ps(grid, 0, c, dp));
        }
        return mi;
    }

    private int ps(int[][] grid, int r, int c, int[][] dp) {
        if (r == grid.length - 1) {
            return grid[r][c];
        }
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int mi = Integer.MAX_VALUE;
        mi = Math.min(mi, grid[r][c] + ps(grid, r + 1, c, dp));
        if (c > 0) {
            mi = Math.min(mi, grid[r][c] + ps(grid, r + 1, c - 1, dp));
        }
        if (c < grid[0].length - 1) {
            mi = Math.min(mi, grid[r][c] + ps(grid, r + 1, c + 1, dp));
        }
        dp[r][c] = mi;
        return mi;
    }

    public static void main(String[] args) {
        MinFaillingPathSum mfps = new MinFaillingPathSum();
        int[][] grid = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(mfps.minFaillingPathSum(grid));
    
    }
}
