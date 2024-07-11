public class BinaryMultiplication {
    public static void main(String[] args) {
        long a = (long)1e7+1;
        long b = (long)1e6+7;
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans += a;
            }
            a <<= 1;
            b >>= 1;
        }
        System.out.println("Result: " + ans);
    }
    
}
