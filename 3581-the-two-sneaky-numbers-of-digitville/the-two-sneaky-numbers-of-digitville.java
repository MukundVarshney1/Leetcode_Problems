class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq=new int[100];
        int[] ans=new int[2];
        int j=0;
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
            if(freq[nums[i]]==2){
                ans[j]=nums[i];
                j++;
            }
            if(j==2){
                return ans;
            }
        }
        return ans;
    }
}