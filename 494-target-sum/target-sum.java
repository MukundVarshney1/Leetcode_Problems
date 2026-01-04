class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp=new int[nums.length+1][2001];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return helper(nums,target,0,0,dp);
    }
    public int helper(int[] nums,int target,int i,int ans,int[][] dp){
        if(i==nums.length){
            if(target==ans){
                return 1;
            }
            return 0;
        }
        if(dp[i][ans+1000]!=-1){
            return dp[i][ans+1000];
        }
        int plus=helper(nums,target,i+1,ans+nums[i],dp);
        int minus=helper(nums,target,i+1,ans-nums[i],dp);
        return dp[i][ans+1000]= plus+minus;
    }
}