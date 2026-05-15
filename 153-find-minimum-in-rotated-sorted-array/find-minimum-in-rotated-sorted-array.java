class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int min=nums[0];
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            min=Math.min(min,nums[mid]);
            if(nums[mid]<nums[nums.length-1]){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return min;
    }
}