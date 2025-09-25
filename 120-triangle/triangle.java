class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int arr[] : dp){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return memo(triangle, 0, 0, n, dp);
    }
     public int memo(List<List<Integer>> list, int i, int j, int n, int dp[][]) {
        if (i == n - 1)
            return list.get(i).get(j);

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int down = list.get(i).get(j) + memo(list, i + 1, j, n, dp);
        int digonal = list.get(i).get(j) + memo(list, i + 1, j + 1, n, dp);

        return dp[i][j] = Math.min(down, digonal);
    }
}