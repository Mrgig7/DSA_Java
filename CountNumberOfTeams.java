public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int c = 0;

        for (int j = 1; j < n - 1; j++) {
            int ll = 0, gl = 0;
            int lr = 0, gr = 0;
            
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    ll++;
                } else if (rating[i] > rating[j]) {
                    gl++;
                }
            }
            
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    lr++;
                } else if (rating[k] > rating[j]) {
                    gr++;
                }
            }
            
            c += ll * gr + gl * lr;
        }
        
        return c;
    }
    public static void main(String[] args) {
        int[] rating = {2,5,3,4,1};
        System.out.println(numTeams(rating));
    }

}