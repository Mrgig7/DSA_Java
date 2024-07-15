public class TargetSum {
    public static  int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (s < Math.abs(target) || (s + target) % 2!= 0) {
            return 0;
        }
        int ts = (s + target) / 2;
        int[] d = new int[ts + 1];
        d[0] = 1;
        for (int num : nums) {
            for (int i = ts; i >= num; i--) {
                d[i] += d[i - num];
            }
        }
        return d[ts];
        
    }
    
    public static void main(String[] args) {
        int[] nums = {100};
        int target = -200;
        System.out.println(findTargetSumWays(nums, target));
    }
}
