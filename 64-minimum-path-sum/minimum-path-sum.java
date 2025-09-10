class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length+1][grid[0].length+1];
		for(int[] a:dp) {
			Arrays.fill(a, -1);
		}
        return minumum_path(grid,0,0,dp);
    }
    public static int minumum_path(int[][] grid,int cr,int cc,int[][] dp) {
		if(cc==grid[0].length-1 && cr==grid.length-1) {
			return grid[cr][cc];
		}
		if(dp[cr][cc]!=-1) {
			return dp[cr][cc];
		}
		if(cc==grid[0].length || cr==grid.length) {
			return Integer.MAX_VALUE;
		}
		int d=minumum_path(grid,cr+1,cc,dp);
		int r=minumum_path(grid,cr,cc+1,dp);
		return dp[cr][cc]=Math.min(d, r)+grid[cr][cc];
	}
}