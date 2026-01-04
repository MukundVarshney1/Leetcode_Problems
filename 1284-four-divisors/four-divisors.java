class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=helper(nums[i]);
        }
        return ans;
    }
    public int helper(int n){
        int c=2;
        int sum=1+n;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                c++;
                sum+=i;
            }
            if(c>4){
                return 0;
            }
        }
        if(c==4){
            return sum;
        }
        return 0;
    }
}