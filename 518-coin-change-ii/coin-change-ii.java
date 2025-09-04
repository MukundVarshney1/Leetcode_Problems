class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length];
		for(int[] a:dp) {
			Arrays.fill(a, -1);
		}
        return Coin_Change(coins,amount,0,dp);
    }
    public static int Coin_Change(int[] coin,int amount,int i,int[][] dp) { // by inclusion-exclusion
		if(amount==0) {
			return 1;
		}
		if(i==coin.length) {
			return 0;
		}
		if(dp[amount][i]!=-1) {
			return dp[amount][i];
		}
		int inc=0;
		int exe=0;
		if(amount>=coin[i]) {
			inc=Coin_Change(coin,amount-coin[i],i,dp);
		}
		exe=Coin_Change(coin,amount,i+1,dp);
		return dp[amount][i]=inc+exe;
	}
}