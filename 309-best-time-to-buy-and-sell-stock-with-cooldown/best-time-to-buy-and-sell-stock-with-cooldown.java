class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return helper(prices,0,0,dp);
    }
    public int helper(int[] p,int i,int hold,int[][] dp){
        if(i>=p.length){
            return 0;
        }
        if(dp[i][hold]!=-1){
            return dp[i][hold];
        }
        if(hold==0){
            int buy=-p[i]+helper(p,i+1,1,dp);
            int skip=helper(p,i+1,0,dp);
            return dp[i][hold]=Math.max(buy,skip);
        }
        else{
            int sell=p[i]+helper(p,i+2,0,dp);
            int skip=helper(p,i+1,1,dp);
            return dp[i][hold]=Math.max(sell,skip);
        }
    }
}