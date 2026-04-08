class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod=1000000007;
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            int c=queries[i][2];
            long d=queries[i][3];
            while(a<=b){
                nums[a]=(int)((nums[a]*d)%mod);
                a+=c;
            }
        }
        int xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor^=nums[i];
        }
        return xor;
    }
}