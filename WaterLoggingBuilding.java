import java.util.*;


public class WaterLoggingBuilding{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        int max=arr[0];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int tot=0;
        int[] l= new int[n];
        int[] r=new int[n];



        int ma=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>ma){
                l[i]=ma;
                ma=arr[i];

            }
            else{
                l[i]=ma;
            }

        }

        ma=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>ma){
                r[i]=ma;
                ma=arr[i];
            }
            else{
                r[i]=ma;
            }
        }
        System.out.print(" L max prefix array ");
        for(int i=0;i<n;i++){
            System.out.print(l[i]+" ");
        }
        System.out.println();
        System.out.print(" R max prefix array ");
        for(int i=0;i<n;i++){
            System.out.print(r[i]+" ");
        }
        System.out.println();

        int sum=0;
        System.out.println("units of water stored in above the building ");
        for(int i=0;i<n;i++){
            if(!(l[i]<arr[i] || r[i]<arr[i])){
                int c = Math.min(l[i], r[i]);
                sum=sum+(c-arr[i]);
                System.out.print((c-arr[i])+" ");
            }
            else{
                System.out.print("0 ");
            }
        }
        System.out.println();
        System.out.println("Sum of all units "+sum);
    }
}