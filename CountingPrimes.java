import java.util.*;

public class CountingPrimes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        int ma = 0;
        for (int i : t) {
            if (i > ma) {
                ma = i;
            }
        }

        int[] pc = Prime(ma);

        for (int i : t) {
            System.out.println(pc[i]);
        }

        sc.close();
    }

    private static int[] Prime(int ma) {
        boolean[] isP = new boolean[ma + 1];
        int[] pc = new int[ma + 1];

        for (int i = 2; i <= ma; i++) {
            isP[i] = true;
        }

        for (int i = 2; i * i <= ma; i++) {
            if (isP[i]) {
                for (int j = i * i; j <= ma; j += i) {
                    isP[j] = false;
                }
            }
        }

        int c = 0;
        for (int i = 0; i <= ma; i++) {
            if (isP[i]) {
                c++;
            }
            pc[i] = c;
        }

        return pc;
    }
}
