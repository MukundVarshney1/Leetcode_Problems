class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
		int[][] dp=new int[matrix.length][matrix[0].length];
		for(int[] a:dp) {
			Arrays.fill(a, -101);
		}
		for(int col=0;col<matrix[0].length;col++) {
			ans=Math.min(ans, Minimum_Falling(matrix,0,col,dp));
		}
        return ans;
    }
    private static int Minimum_Falling(int[][] matrix, int cr, int cc,int[][] dp) {
		if(cc<0 || cc>=matrix[0].length) {
			return Integer.MAX_VALUE;
		}
		if(cr==matrix.length-1) {
			return matrix[cr][cc];
		}
		if(dp[cr][cc]!=-101) {
			return dp[cr][cc];
		}
		int ld=Minimum_Falling(matrix,cr+1,cc-1,dp);
		int rd=Minimum_Falling(matrix,cr+1,cc+1,dp);
		int d=Minimum_Falling(matrix,cr+1,cc,dp);
		return dp[cr][cc]=Math.min(Math.min(rd, d), ld)+matrix[cr][cc];
	}
}