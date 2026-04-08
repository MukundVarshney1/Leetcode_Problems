class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] dp=new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return helper(obstacleGrid,0,0,dp);
    }
    public static int helper(int[][] grid,int i,int j,Integer[][] dp){
        if(i==grid.length || j==grid[0].length || grid[i][j]==1){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        return dp[i][j]=helper(grid,i+1,j,dp)+helper(grid,i,j+1,dp);
    }
}