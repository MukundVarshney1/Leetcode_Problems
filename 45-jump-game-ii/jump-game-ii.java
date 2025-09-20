class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            dp[i]=-1;
        }
        return helper(nums,0,dp);
    }
    public int helper(int[] nums,int idx,int[] dp){
        if(idx==nums.length-1){
            return 0;
        }
        if(idx>nums.length-1){
            return Integer.MAX_VALUE;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx] && idx + i < nums.length; i++){
            int a=helper(nums,idx+i,dp);
            if(a!=Integer.MAX_VALUE){
                ans=Math.min(ans,a+1);
            }
        }
        return dp[idx]=ans;
    }
}