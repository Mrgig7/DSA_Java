import java.util.*;
public class TwoQuerySubarraySum {
    public static void main(String[ ]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =new int[n];
        for(int i = 0 ;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];
        for(int i = 0 ;i<q;i++){
            l[i] = sc.nextInt();
        }
        for(int i = 0 ;i<q;i++){
            r[i] = sc.nextInt();
        }
        for(int  j= 0; j<q;j++){
            System.out.print("Sum of the subarray");
            for(int i=arr[l[j]];i<=arr[r[j]];i++){
                System.out.print(" "+i);
            }
            System.out.println();
        }
    }
}
