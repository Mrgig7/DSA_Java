//import java.util.*;
//
//public class bitmasking_subsets {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//
//        for(int i; i<(1<<n);i++){
//            int sum = 0;
//            for(int j = 0; j<n;j++){
//                if(i&(1<<j)){
//                    sum = sum^arr[j];
//                }
//            }
//        }
//
//    }
//}