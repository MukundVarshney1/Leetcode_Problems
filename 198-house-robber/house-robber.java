class Solution {
    public int rob(int[] nums) {
        return Robber(nums);
    }
   public static int Robber(int[] arr) {
		if(arr.length<2) {
			return arr[0];
		}
		int[] dp=new int[arr.length];
		dp[0]=arr[0];
		dp[1]=Math.max(arr[1],dp[0]);
		for(int i=2;i<dp.length;i++) {
			int rob=arr[i]+dp[i-2];
			int unrob=dp[i-1];
			dp[i]=Math.max(rob, unrob);
		}
		return dp[dp.length-1];
	}
}