
import java.util.*;

public class Kthbitset_unset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = 1 << (k - 1);

        if ((n & m) == m) {
            System.out.println("set");
        } else {
            System.out.println("unset");
        }
    }
}
