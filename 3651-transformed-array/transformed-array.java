class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] a=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int rem=(i+nums[i])%nums.length;
            if(rem<0){
                rem+=nums.length;
            }
            a[i]=nums[rem];
        }
        return a;
    }
}