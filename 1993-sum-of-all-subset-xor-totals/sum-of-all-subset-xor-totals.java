class Solution {
    int res=0;
    public void backtrack(int[] nums,int idx,ArrayList temp){
        if(idx==nums.length){
            int xor=0;
            for(int i=0;i<temp.size();i++){
                xor=xor^(int)temp.get(i);
            }
            res+=xor;
            return;
        }
        temp.add(nums[idx]);
        backtrack(nums,idx+1,temp);
        temp.remove(temp.size()-1);
        backtrack(nums,idx+1,temp);
    }
    public int subsetXORSum(int[] nums) {
        ArrayList<Integer>temp=new ArrayList<>();
        backtrack(nums,0,temp);
        return res;
    }
}
