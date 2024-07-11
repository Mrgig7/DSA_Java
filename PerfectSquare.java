import java.util.*;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a==1){
            return;
        }
        int d = (int) Math.sqrt(a);
        if (d * d == a) {
            System.out.println(a + " is a perfect square and "+ d+ " is the square root of it.");
        } else {
            System.out.println(a + " is not a perfect square");
        }
    }
}
