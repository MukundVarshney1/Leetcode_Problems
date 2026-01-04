class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
       return helper(s,0,dp);
    }
    public int helper(String s,int i,int[] dp){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int x=helper(s,i+1,dp);
        if(!isval(s,i)){
            return dp[i]=x;
        }
        return dp[i]=x+helper(s,i+2,dp);
    }
    public boolean isval(String s,int i){
        if(s.length()-i<2){
            return false;
        }
        if(s.charAt(i)>'2'){
            return false;
        }
        if(s.charAt(i)=='2' && s.charAt(i+1)>'6'){
            return false;
        }
        return true;
    }
}