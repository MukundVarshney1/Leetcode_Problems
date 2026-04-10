class Solution {
    public int minimumDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    for(int k=j+1;k<nums.length;k++){
                        if(nums[j]==nums[k]){
                            ans=Math.min(ans,2*(k-i));
                        }
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}