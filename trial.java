class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ptr=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==x){
                dp[ptr++]=i;
            }
        }
        int[] ans = new int[queries.length];
        ptr=0;
        for(int query: queries){
            if(query-1>=dp.length){
                ans[ptr++]=-1;
                continue;
            }
            ans[ptr++]=dp[query-1];
        }
        return ans;
    }
}