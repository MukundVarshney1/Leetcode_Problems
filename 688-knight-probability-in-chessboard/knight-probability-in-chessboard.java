class Solution {
    public double knightProbability(int n, int k, int row, int col) {
        double[][][] dp=new double[n][n][k+1];
        double h = helper(n, k, row, col,dp);
        return h / Math.pow(8, k);
    }

    public double helper(int n, int k, int r, int c,double[][][] dp) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if(dp[r][c][k]!=0){
            return dp[r][c][k];
        }
        double a = 0;
        a += helper(n, k - 1, r + 2, c + 1,dp);
        a += helper(n, k - 1, r + 2, c - 1,dp);
        a += helper(n, k - 1, r - 2, c - 1,dp);
        a += helper(n, k - 1, r - 2, c + 1,dp);
        a += helper(n, k - 1, r - 1, c - 2,dp);
        a += helper(n, k - 1, r + 1, c + 2,dp);
        a += helper(n, k - 1, r + 1, c - 2,dp);
        a += helper(n, k - 1, r - 1, c + 2,dp);
        return dp[r][c][k]=a;
    }
}