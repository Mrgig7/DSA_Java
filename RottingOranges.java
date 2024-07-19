import java.util.*;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {   
        int m = grid.length;
        int n = grid[0].length;
        int fo = 0;
        int ro = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fo++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }            
            }
        }
        
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int a = 0;
        
        while (!q.isEmpty() && fo > 0) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int[] t = q.poll();
                for (int[] d : dir) {
                    int x = t[0] + d[0];
                    int y = t[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                        ro++;
                        fo--;
                    }
                }
            }
            a++;
        }
        return fo == 0 ? a : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottingOranges rottenOranges = new RottingOranges();
        System.out.println(rottenOranges.orangesRotting(grid)); // Output should be 4
    }
}
