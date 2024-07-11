import java.util.*;
public class ProductMax{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i= 0; i<n ;i++){
            a[i]=sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();

        Arrays.sort(a);

        int k = Math.max(p,q);
        int l = Math.max(q,r);
        int m = Math.max(r,p);



    }
}

