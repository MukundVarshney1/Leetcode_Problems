class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp=new Boolean[s.length()][s.length()+1];
        return helper(s,0,0,dp);
    }
    public boolean helper(String s,int i,int p,Boolean[][] dp){
        if(p<0 || i==s.length()){
            if(p==0){
                return true;
            }
            return false;
        }
        boolean a=false;
        boolean b=false;
        boolean c=false;
        if(dp[i][p]!=null){
            return dp[i][p];
        }
        if(s.charAt(i)=='('){
            a=helper(s,i+1,p+1,dp);
        }
        else if(s.charAt(i)==')'){
            a=helper(s,i+1,p-1,dp);
        }
        else{
            a=helper(s,i+1,p-1,dp);
            b=helper(s,i+1,p+1,dp);
            c=helper(s,i+1,p,dp);
        }
        return dp[i][p]= a | b | c;
    }

}