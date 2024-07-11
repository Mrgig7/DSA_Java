import java.util.*;
public class PrimeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int f = 0;
        for(int i = 2;i*i<=a;i++){
            if(a%i==0) {
                f++;
            }
        }
        if(f>0){
            System.out.println(a +" is not a prime number");
        }else{
            System.out.println(a + " is a prime number");
        }
    }
}
