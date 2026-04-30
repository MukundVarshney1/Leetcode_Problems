class Solution {
public int maxPathScore(int[][] grid, int k) {
        int[][][] dp=new int[grid.length][grid[0].length][k+1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int l=0;l<=k;l++){
                    dp[i][j][l]=-2;
                }
            }
        }
        return helper(grid,k,dp,0,0,0);
    }

public int helper(int[][] grid,int k,int[][][] dp,int row,int col,int cost){
        if(row==grid.length || col==grid[0].length || cost>k){
            return -1;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            if(cost+(grid[row][col]==0?0:1)>k){
                return -1;
            }
            return grid[row][col];
        }
        if(dp[row][col][cost]!=-2){
            return dp[row][col][cost];
        }
        int a=helper(grid,k,dp,row+1,col,cost+(grid[row][col]==0?0:1));
        int b=helper(grid,k,dp,row,col+1,cost+(grid[row][col]==0?0:1));
        if(a==-1 && b==-1){
            return dp[row][col][cost]=-1;
        }
        return dp[row][col][cost]=Math.max(a,b)+grid[row][col];
    }
}