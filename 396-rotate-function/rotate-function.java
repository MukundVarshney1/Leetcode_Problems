class Solution {
    public int maxRotateFunction(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int sum=0;
        int prev=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            prev+=nums[i]*i;
        }
        ans=Math.max(ans,prev);
        for(int i=nums.length-1;i>=1;i--){
            int tans=prev-nums[i]*nums.length+sum;
            ans=Math.max(tans,ans);
            prev=tans;
        }
        return ans;
    }
}