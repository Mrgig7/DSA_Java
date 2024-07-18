import java.util.*;

public class Graph_Cycle {
    static HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();

    static boolean isCyclicUtil(int node, boolean visited[], int parent) {
        visited[node] = true;
        for (int neighbour : list.get(node)) {
            if (!visited[neighbour]) {
                if (isCyclicUtil(neighbour, visited, node)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[list.size() + 1];
        for (int node : list.keySet()) {
            if (!visited[node]) {
                if (isCyclicUtil(node, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (list.containsKey(a)) {
                list.get(a).add(b);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(b);
                list.put(a, arr);
            }
            if (list.containsKey(b)) {
                list.get(b).add(a);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(a);
                list.put(b, arr);
            }
        }
        Graph_Cycle graph = new Graph_Cycle();
        boolean cycle = graph.isCyclic();
        if (cycle) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does not contain cycle");
        }
    }
}
