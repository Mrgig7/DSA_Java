import java.util.ArrayList;

public class PrintLongestIncreasingSubsequence {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        int[] lis = new int[n];
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) {
            lis[i] = 1;
            prev[i] = -1;
        }
        
        // Compute LIS values
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
        }
        
        int mi = 0;
        for(int i = 1; i < n; i++) {
            if(lis[i] > lis[mi]) {
                mi = i;
            }
        }
        
        return printLIS(prev, mi, arr);
    }

    private ArrayList<Integer> printLIS(int[] prev, int index, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for(; index >= 0; index = prev[index]) {
            result.add(0, arr[index]); 
        }
        return result;
    }

    public static void main(String[] args) {
        PrintLongestIncreasingSubsequence plis = new PrintLongestIncreasingSubsequence();
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = arr.length;
        ArrayList<Integer> result = plis.longestIncreasingSubsequence(n, arr);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}
