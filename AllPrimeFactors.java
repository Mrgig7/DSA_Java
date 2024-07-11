import java.util.*;

public class AllPrimeFactors {
    static List<List<Integer>> precomputePrimeFactors(int maxN) {
        List<List<Integer>> allFactors = new ArrayList<>();
        for (int i = 0; i <= maxN; i++) {
            allFactors.add(new ArrayList<>());
        }

        for (int p = 2; p <= maxN; p++) {
            if (allFactors.get(p).isEmpty()) {
                for (int k = p; k <= maxN; k += p) {
                    allFactors.get(k).add(p);
                }
            }
        }

        return allFactors;
    }

    static void printAllPrimeFactors(int[] arr, List<List<Integer>> allFactors) {
        for (int num : arr) {
            System.out.println("All prime factors of " + num + ": " + allFactors.get(num));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int maxN = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > maxN) {
                maxN = arr[i];
            }
        }
        List<List<Integer>> allFactors = precomputePrimeFactors(maxN);
        printAllPrimeFactors(arr, allFactors);

        sc.close();
    }
}
