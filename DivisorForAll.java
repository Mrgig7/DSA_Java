import java.util.*;

public class DivisorForAll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ma = Arrays.stream(a).max().orElse(0);
        ArrayList<Integer>[] factors = new ArrayList[ma + 1];
        for (int i = 0; i <= ma; i++) {
            factors[i] = new ArrayList<>();
        }
        for (int i = 1; i <= ma; i++) {
            for (int j = i; j <= ma; j += i) {
                factors[j].add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Factors of " + a[i] + ": " + factors[a[i]]);
        }
    }
}
