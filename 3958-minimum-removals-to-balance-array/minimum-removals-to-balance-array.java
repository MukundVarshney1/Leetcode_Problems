class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int si=0;
        int ei=0;
        int ans=0;
        while(ei<nums.length){ 
            while(nums[ei]>(long)nums[si]*k && si<ei){
                si++;
            }
            ans=Math.max(ei-si+1,ans);
            ei++;
        }
        return nums.length-ans;
    }
}