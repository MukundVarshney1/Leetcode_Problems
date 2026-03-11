class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ei=0;
        int si=0;
        int ans=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(si<=i && sum>=target){
                ans=Math.min(ans,i-si+1);
                sum-=nums[si++];
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}