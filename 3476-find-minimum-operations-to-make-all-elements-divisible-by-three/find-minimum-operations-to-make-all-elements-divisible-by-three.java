class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=nums[i]%3<2?nums[i]%3:3-nums[i]%3;
        }
        return ans;
    }
}