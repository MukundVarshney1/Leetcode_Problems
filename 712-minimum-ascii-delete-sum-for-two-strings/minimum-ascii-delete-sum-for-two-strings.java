class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return helper(s1,s2,0,0,dp);
    }
    public int helper(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length()){
            return ascii(s2,j);
        }
        if(j==s2.length()){
            return ascii(s1,i);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=helper(s1,s2,i+1,j+1,dp);
        }
        return dp[i][j]=Math.min(helper(s1,s2,i+1,j,dp)+s1.charAt(i),helper(s1,s2,i,j+1,dp)+s2.charAt(j));
    }
    public int ascii(String s,int i){
        int ans=0;
        for(int j=i;j<s.length();j++){
            ans+=s.charAt(j);
        }
        return ans;
    }
}