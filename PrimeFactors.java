import java.util.*;
public class PrimeFactors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i=2;i*i<=a;i++){
            while(a%i==0){
                a /= i;
                System.out.println(i);
            }
        }
        if(a>1) System.out.println(a);
    }
}
