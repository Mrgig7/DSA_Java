import java.util.*;

public class LPF {
    void lpf(int n) {
        int[] lpf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            lpf[i] = i;
        }
        for (int p = 2; p * p <= n; p++) {
            if (lpf[p] == p) {
                for (int i = p * p; i <= n; i += p) {
                    if (lpf[i] == i) {
                        lpf[i] = p;
                    }
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println("Smallest prime factor of " + i + " is " + lpf[i]);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LPF g = new LPF();
        g.lpf(n);
    }
}
