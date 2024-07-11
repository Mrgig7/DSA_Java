import java.util.*;
public class sumofGivenindex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n ;i++){
            arr[i] = sc.nextInt();
        }
        int l = sc.nextInt();
        int r = sc.nextInt();
        int sum = 0;
        for(int i = 0; i<n;i++){
            if(i>=l&&i<=r){
                sum+=arr[i];
            }
        }
        System.out.println("Sum of given index sub array = "+sum);
    }
}
