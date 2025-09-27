class Solution {
    public int maxSubarraySumCircular(int[] nums) {  
        int total=nums[0];
        int min=nums[0];
        int max=nums[0];
        int t_max=nums[0];
        int t_min=nums[0];
        for(int i=1;i<nums.length;i++){
            min=Math.min(min+nums[i],nums[i]);
            max=Math.max(max+nums[i],nums[i]);
            t_max=Math.max(max,t_max);
            t_min=Math.min(min,t_min);
            total+=nums[i];
        }
        if(t_max>0){
            return Math.max(t_max,total-t_min);
        }
        return t_max;

    }
}