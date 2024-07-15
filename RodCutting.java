import java.util.*;
public class RodCutting {
    public int cutRod(int price[], int n) {
        int[] r = new int[n+1];
        Arrays.fill(r, Integer.MIN_VALUE);
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                r[i] = Math.max(r[i], price[j-1] + r[i-j]);
        }
        return r[n];
        
    }
    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n+1];
        for (int i = 1; i <= n; i++){
        price[i] = sc.nextInt();
        }
        System.out.println(rc.cutRod(price, n));
    }

}
