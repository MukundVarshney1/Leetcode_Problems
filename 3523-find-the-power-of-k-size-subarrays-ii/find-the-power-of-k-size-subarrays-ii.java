class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        int c=1;
        int[] ans=new int[nums.length-k+1];
        int temp=0;
        for(int i=1;i<k;i++){
            if(nums[i]!=nums[i-1]+1){
                ans[0]=-1;
                temp=i;
            }
        }
        if(temp==0){
            ans[0]=nums[k-1];
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                temp=i;
            }
            if(i-temp+1>=k){
                ans[c++]=nums[i];
            }
            else{
                ans[c++]=-1;
            }
        }
        return ans;
    }
}