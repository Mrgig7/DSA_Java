import java.util.ArrayList;
import java.util.List;

public class MinimumCostForCuttingCakeI {
 public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        List<int[]> cuts = new ArrayList<>();
        for (int i = 0; i < horizontalCut.length; i++) {
            cuts.add(new int[]{horizontalCut[i], 0});
        }
        for (int j = 0; j < verticalCut.length; j++) {
            cuts.add(new int[]{verticalCut[j], 1});
        }
        cuts.sort((a, b) -> b[0] - a[0]);
        int h = 1,v = 1,t = 0;
        for (int[] cut : cuts) {
            if (cut[1] == 0) {
                t += cut[0] * v;
                h++;
            } else {
                t += cut[0] * h;
                v++;
            }
        }
        return t;
    }
    public static void main(String[] args) {
        MinimumCostForCuttingCakeI obj = new MinimumCostForCuttingCakeI();
        int m = 5, n = 4, horizontalCut = {1, 2, 4}, verticalCut = {1, 3};
        System.out.println(obj.minimumCost(m, n, horizontalCut, verticalCut)); 
    }
}


