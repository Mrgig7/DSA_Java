
import java.util.Scanner;

public class Noofsetbits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = 0;
        while (a > 0) {
            a = a & (a - 1);
            c++;
        }
        System.out.println("Number of set bits: " + c);
    }
}