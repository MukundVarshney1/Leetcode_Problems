class Solution {
    public int longestOnes(int[] nums, int k) {
        int ei=0;
        int si=0;
        int ans=0;
        int max=0;
        while(ei<nums.length){
            if(nums[ei]==1){
                ans++;
                ei++;
            }
            else if(nums[ei]==0 && k>0){
                k--;
                ans++;
                ei++;
            }
            else{
                while(si<=ei && k==0){
                    if(nums[si]==0){
                        k++;
                    }
                    ans--;
                    si++;
                }
            }
            max=Math.max(ans,max);
        }
        return max;
    }
}