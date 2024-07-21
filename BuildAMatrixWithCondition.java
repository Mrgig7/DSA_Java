import java.util.*;

public class BuildAMatrixWithCondition {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] r = new int[k][k];
        List<Integer> ro = topologicalSort(k, rowConditions);
        List<Integer> co = topologicalSort(k, colConditions);
        if (ro == null || co == null) {
            return new int[0][0];
        }
        int[] rp = new int[k + 1];
        int[] cp = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rp[ro.get(i)] = i;
            cp[co.get(i)] = i;
        }
        for (int i = 1; i <= k; i++) {
            r[rp[i]][cp[i]] = i;
        }
        
        return r;
    }
    
    private List<Integer> topologicalSort(int k, int[][] cd) {
        int[] id = new int[k + 1];
        List<Integer>[] g = new List[k + 1];
        
        for (int i = 1; i <= k; i++) {
            g[i] = new ArrayList<>();
        }
        
        for (int[] c : cd) {
            g[c[0]].add(c[1]);
            id[c[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (id[i] == 0) {
                q.add(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int n : g[node]) {
                id[n]--;
                if (id[n] == 0) {
                    q.add(n);
                }
            }
        }
        
        if (order.size() == k) {
            return order;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        BuildAMatrixWithCondition bamwc = new BuildAMatrixWithCondition();
        int[][] rowConditions = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] colConditions = {{1, 3}, {2, 4}, {3, 5}, {4, 1}};
        int[][] result = bamwc.buildMatrix(5, rowConditions, colConditions);
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
