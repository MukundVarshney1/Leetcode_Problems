class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==2){
                ans[i]=-1;
            }
            else{
                for(int j=0;j<32;j++){
                    if(((1<<j)&nums.get(i))==0){
                        ans[i]=(nums.get(i)^(1<<j-1));
                        break;
                    }
                }
            }
        }
        return ans;
    }
}