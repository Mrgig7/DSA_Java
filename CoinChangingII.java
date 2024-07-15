public class CoinChangingII {
        public int change(int a, int[] c) {
            int r[] = new int[a+1];
            r[0] = 1;
            for(int co : c)
                for(int i = co; i <= a; i++)
                    r[i] += r[i-co];
            return r[a];
        }

        public static void main(String[] args) {
            CoinChangingII cc = new CoinChangingII();
            System.out.println(cc.change(5, new int[]{1, 2, 5})); // Output: 4
        }
    
}
