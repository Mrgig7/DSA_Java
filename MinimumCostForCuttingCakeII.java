import java.util.ArrayList;
import java.util.List;

public class MinimumCostForCuttingCakeII {
 public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        List<int[]> cu = new ArrayList<>();
        for (int i = 0; i < horizontalCut.length; i++) {
            cu.add(new int[]{horizontalCut[i], 0});
        }
        for (int j = 0; j < verticalCut.length; j++) {
            cu.add(new int[]{verticalCut[j], 1});
        }
        cu.sort((a, b) -> b[0] - a[0]);
        int h = 1, v = 1;
        long t = 0;
        for (int[] cut : cu) {
            if (cut[1] == 0) {
                t += (long) cut[0] * v;
                h++;
            } else { 
                t += (long) cut[0] * h;
                v++;
            }
        }
        return t;
    }
    public static void main(String[] args) {
        MinimumCostForCuttingCakeII obj = new MinimumCostForCuttingCakeII();
        int m = 5, n = 4;
        int[] horizontalCut = {1, 2, 4};
        int[] verticalCut = {1, 3};
        System.out.println(obj.minimumCost(m, n, horizontalCut, verticalCut));
    }
}
