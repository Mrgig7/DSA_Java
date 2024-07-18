
import java.util.*;


public class Graph{
    static HashMap<Integer,ArrayList<Integer>> list = new HashMap<>();
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
    }
}