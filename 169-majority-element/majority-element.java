class Solution {
    public int majorityElement(int[] nums) {
        int ele=nums[0];
        int val=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==ele){
                val++;
            }
            else{
                val--;
                if(val==0){
                    val=1;
                    ele=nums[i];
                }
            }
        }
        return ele;
    }
}