class Solution {
    public int minimumDistance(String word) {
        Integer[][][] dp=new Integer[word.length()][27][27];
        return helper(word,0,26,26,dp);
    }
    public int helper(String s,int i,int f1,int f2,Integer[][][] dp){
        if(i==s.length()){
            return 0;
        }
        if(dp[i][f1][f2]!=null){
            return dp[i][f1][f2];
        }
        int ans=Integer.MAX_VALUE;
        if(f1==26){
            ans=Math.min(ans,helper(s,i+1,s.charAt(i)-'A',f2,dp));
        }
        else{
            int temp=helper(s,i+1,s.charAt(i)-'A',f2,dp);
            temp+=Math.abs(f1/6-(s.charAt(i)-'A')/6)+Math.abs(f1%6-(s.charAt(i)-'A')%6);
            ans=Math.min(ans,temp);
        }
        if(f2==26){
            ans=Math.min(ans,helper(s,i+1,f1,s.charAt(i)-'A',dp));
        }
        else{
            int temp=helper(s,i+1,f1,s.charAt(i)-'A',dp);
            temp+=Math.abs(f2/6-(s.charAt(i)-'A')/6)+Math.abs(f2%6-(s.charAt(i)-'A')%6);
            ans=Math.min(ans,temp);
        }
        return dp[i][f1][f2]=ans;
    }
}