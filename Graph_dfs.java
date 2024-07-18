

import java.util.*;


public class Graph_dfs{
    static HashMap<Integer,ArrayList<Integer>> list = new HashMap<>();
    static HashMap<Integer,Integer> visited = new HashMap<>();
    public static void dfs(int root){
        System.out.println(root);
        visited.put(root,1);
        for(int b : list.get(root)){
            if(!visited.containsKey(b)){
                dfs(b);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(list.containsKey(a)){
                list.get(a).add(b);
            }
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(b);
                list.put(a,arr);
            }
            if(list.containsKey(b)){
                list.get(b).add(a);
            }
            else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(a);
                list.put(b,arr);
            }
        }
        System.out.println(list);
        dfs(1);
        
    }
}