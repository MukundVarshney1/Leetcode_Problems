class Solution {
    public int findMin(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        int ans=nums[0];
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            ans=Math.min(ans,nums[mid]);
            if(nums[mid]<nums[nums.length-1]){
                hi=mid-1;
            }
            else if(nums[mid]>nums[hi]){
                lo=mid+1;
            }
            else{
                hi--;
            }
        }
        return ans;
    }
}