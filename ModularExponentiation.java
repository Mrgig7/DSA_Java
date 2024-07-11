import java.util.*;

public class ModularExponentiation {
    public static long modularExponentiation(long a, long b, long MOD) {
        long ans = 1;
        a = a % MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }
            a = (a * a) % MOD;
            b = b >> 1;
        }
        return ans;d 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long MOD = sc.nextLong() ;

        System.out.println("Result: " + modularExponentiation(a, b, MOD));
    }
}
