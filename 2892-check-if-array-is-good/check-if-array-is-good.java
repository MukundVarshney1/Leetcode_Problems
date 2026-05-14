class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int c=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=c){
                return false;
            }c++;
        }
        return nums[nums.length-1]==c-1;
    }
}