import java.util.*;

public class Factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int samp = value;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=2;i*i<value;i++){
            while(value%i==0){
                value=value/i;
                if(mp.containsKey(i)){
                    mp.put(i,mp.get(i)+1);
                }
                else{
                    mp.put(i,1);
                }
            }
        }
        if(value>1){
            mp.put(value,1);
        }
        System.out.println(mp);
        int count=1;
        int sum=1;
        for(Map.Entry<Integer,Integer> se : mp.entrySet()){
            int valu = ((int)Math.pow(se.getKey(),se.getValue()+1) - 1 ) / (se.getKey() - 1);
            sum*=valu;
            count*=se.getValue()+1;

        }
        if(count%2==0){
            System.out.println("Product of divisor :"+(long)(Math.pow(samp,(count/2))));
        }
        else{
            System.out.println("Product of divisors: "+(Math.pow(samp,((count+1)/2))));
        }
        System.out.println("count of divisors : "+count);
        System.out.println("Sum value : "+sum);


    }
}