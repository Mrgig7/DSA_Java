import java.util.*;

public class Toposort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, adj);
        }
        int[] topoOrder = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            topoOrder[index++] = stack.pop();
        }
        
        return topoOrder;
    }
    
    static void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack, adj);
        }
        stack.push(v);
    }
    
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        System.out.println("Following is a Topological Sort of given graph");
        int[] topoOrder = topoSort(V, adj);
        for (int i : topoOrder) {
            System.out.print(i + " ");
        }
    }
}
