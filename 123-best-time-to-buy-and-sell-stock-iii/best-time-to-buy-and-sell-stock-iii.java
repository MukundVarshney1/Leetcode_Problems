class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int h = 0; h < 2; h++) {
                for (int t = 0; t < 3; t++) {
                    dp[i][h][t] = -1;
                }
            }
        }
        return helper(prices,0,0,dp,0);
    }
    public int helper(int[] p,int i,int hold,int[][][] dp,int t){
        if(i>=p.length){
            return 0;
        }
        if(t==2){
            return 0;
        }
        if(dp[i][hold][t]!=-1){
            return dp[i][hold][t];
        }
        if(hold==0){
            int buy=-p[i]+helper(p,i+1,1,dp,t);
            int skip=helper(p,i+1,0,dp,t);
            return dp[i][hold][t]=Math.max(buy,skip);
        }
        else{
            int sell=p[i]+helper(p,i+1,0,dp,t+1);
            int skip=helper(p,i+1,1,dp,t);
            return dp[i][hold][t]=Math.max(sell,skip);
        }
    }
}