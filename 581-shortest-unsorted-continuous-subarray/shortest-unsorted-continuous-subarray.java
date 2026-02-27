class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max=nums[0];
        int si=-1;
        int ei=-1;
        int min=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<max){
                ei=i;
            }
            max=Math.max(nums[i],max);
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>min){
                si=i;
            }
            min=Math.min(nums[i],min);
        }
        return ei==-1 || si==-1?0:ei-si+1;
    }
}