import java.util.*;

public class Kthbitset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = 1 << (k - 1);

        int r = n | m;

        System.out.println(r);
    }
}
