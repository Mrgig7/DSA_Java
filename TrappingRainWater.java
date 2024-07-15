public class TrappingRainWater {
        public int trap(int[] height) {
            int n = height.length;
            int l = 0, r = n - 1;
            int res = 0;
            int mal = 0, mar = 0;
    
            while (l <= r) { 
                if (height[l] <= height[r]) {
                    if (height[l] >= mal)
                        mal = height[l];
                    else
                        res += mal - height[l];
                    l++;
                } else { 
                    if (height[r] >= mar)
                        mar = height[r];
                    else
                        res += mar - height[r]; 
                    r--;
                }
            }
            return res;
        }
        
        public static void main(String[] args) {
            TrappingRainWater trap = new TrappingRainWater();
            int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
            System.out.println("Maximum water that can be trapped is " + trap.trap(height));
        }
}
