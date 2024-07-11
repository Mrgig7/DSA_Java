import java.util.Scanner;

public class bitmasking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        StringBuilder b = new StringBuilder();
        while (d > 0) {
            b.append(d % 2);
            d /= 2;
        }

        System.out.println(b.reverse().toString());
    }
}
