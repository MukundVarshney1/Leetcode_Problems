class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int a=0;
            for(int j=i;j<nums.length;j++){
                a|=nums[j];
                if(a>=k){
                    ans=Math.min(ans,j-i+1);
                }
            }
        }
        return ans!=Integer.MAX_VALUE?ans:-1;
    }
}