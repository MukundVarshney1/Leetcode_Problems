class Solution {
    public int smallestAbsent(int[] nums) {
        HashSet<Integer> values=new HashSet<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            values.add(nums[i]);
        }
        int result=sum/nums.length+1;
        while(values.contains(result) || result<=0) {
            result++;
        }
        return result;
    }
}