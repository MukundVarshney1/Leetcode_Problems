class Solution {
    public int maximumAmount(int[][] coins) {
        Integer[][][] dp=new Integer[coins.length][coins[0].length][3];
        return helper(coins, 0, 0, 0,dp);
    }

    public static int helper(int[][] coins,int i,int j,int k,Integer[][][] dp){
        if(i==coins.length || j==coins[0].length || k>2){
            return Integer.MIN_VALUE/2;
        }
        if(i==coins.length-1 && j==coins[0].length-1){
            if(coins[i][j]>=0){
                return coins[i][j];
            }
            if(k<2){
                return 0;
            }
            return coins[i][j];
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        if(coins[i][j]>=0){
            return dp[i][j][k]= Math.max(helper(coins,i+1,j,k,dp),helper(coins,i,j+1,k,dp))+coins[i][j];
        }
        else{
            int rob=Math.max(helper(coins,i+1,j,k,dp),helper(coins,i,j+1,k,dp))+coins[i][j];
            int drob=Math.max(helper(coins,i+1,j,k+1,dp),helper(coins,i,j+1,k+1,dp));
            return dp[i][j][k]= Math.max(rob,drob);
        }
    }
}