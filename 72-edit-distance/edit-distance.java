class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return helper(word1,word2,0,0,dp);
    }
    public int helper(String w1,String w2,int i,int j,int[][] dp){
        if(i==w1.length()){
            return w2.length()-j;
        }
        if(j==w2.length()){
            return w1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(w1.charAt(i)==w2.charAt(j)){
             return dp[i][j]= helper(w1,w2,i+1,j+1,dp);
        }
        else{
            int a=helper(w1,w2,i,j+1,dp);
            int b=helper(w1,w2,i+1,j,dp);
            int c=helper(w1,w2,i+1,j+1,dp);
            return dp[i][j]=Math.min(Math.min(a,b),c)+1;
        }
    }
}