class Solution {
    public int matrixSum(int[][] nums) {
        int m=nums[0].length;
        int sum=0;
        for(int i=0;i<m;i++){
            int max=0;
            for(int j=0;j<nums.length;j++){
                max=Math.max(max,helper(nums[j]));
            }
            sum+=max;
        }
        return sum;
    }
    public static int helper(int[] a){
        int max=a[0];
        int id=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
                id=i;
            }
        }
        a[id]=-1;
        return max;
    }
}