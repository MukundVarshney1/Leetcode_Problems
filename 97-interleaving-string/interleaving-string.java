class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp=new Boolean[s1.length()+1][s2.length()+1];

        return helper(s1, s2, s3, 0, 0,dp);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j,Boolean[][] dp) {
        if (i == s1.length() && j == s2.length() && i+j==s3.length()) {
            return true;
        }

        boolean takeS1 = false, takeS2 = false;
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            takeS1 = helper(s1, s2, s3, i + 1, j,dp);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            takeS2 = helper(s1, s2, s3, i, j + 1,dp);
        }

        return dp[i][j]=takeS1 || takeS2;
    }
}
