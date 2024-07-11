import java.util.*;

public class HPF {
    void hpf(int n) {
        int[] hpf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            hpf[i] = i;
        }
        for (int p = 2; p <= n; p++) {
            if (hpf[p] == p) {
                for (int i = p * 2; i <= n; i += p) {
                    hpf[i] = p;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println("Highest prime factor of " + i + " is " + hpf[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HPF g = new HPF();
        g.hpf(n);
    }
}
