class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1){
            return 0;
        }
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=k-1;
        while(j<nums.length){
            ans=Math.min(ans,nums[j++]-nums[i++]);
        }
        return ans;
    }
}