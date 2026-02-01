class Solution {
    public int minimumCost(int[] nums) {
        int min=Integer.MAX_VALUE;
        int smin=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=min){
                smin=min;
                min=nums[i];
            }
            else if(nums[i]<smin){
                smin=nums[i];
            }
        }
        return nums[0]+min+smin;
    }
}