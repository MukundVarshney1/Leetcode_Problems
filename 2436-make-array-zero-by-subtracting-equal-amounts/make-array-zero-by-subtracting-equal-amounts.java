class Solution {
    public int minimumOperations(int[] nums) {
    int ans=0;
       while(true){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min && nums[i]!=0){
                min=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[i]-=min;
            }
        }
        if(min==Integer.MAX_VALUE){
            return ans;
        }
        ans++;
       }
    }
}