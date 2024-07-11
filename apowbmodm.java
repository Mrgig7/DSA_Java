import java.math.BigInteger;


// (a^b)%m for b very large.

class apowbmodm {
    public static void main(String[] args) {
        int a = 2; // base
        BigInteger b = new BigInteger("12345678901234567890"); // exponent
        int m = 1000000007; // modulus

        BigInteger result = modularExponentiation(a, b, m);
        System.out.println(result);
    }

    public static BigInteger modularExponentiation(int a, BigInteger b, int m) {
        BigInteger result = BigInteger.ONE;
        BigInteger base = BigInteger.valueOf(a);

        while (b.compareTo(BigInteger.ZERO) > 0) {
            if (b.testBit(0)) {
                result = result.multiply(base).mod(BigInteger.valueOf(m));
            }
            base = base.multiply(base).mod(BigInteger.valueOf(m));
            b = b.shiftRight(1);
        }

        return result;
    }
}


