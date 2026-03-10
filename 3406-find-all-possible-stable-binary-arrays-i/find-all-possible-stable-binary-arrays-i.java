class Solution {
    long mod=1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][][] dp=new long[zero+1][one+1][3][limit+1];
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                for(int k=0;k<=2;k++){
                    for(int l=0;l<=limit;l++){
                        dp[i][j][k][l]=-1;
                    }
                }
            }
        }
        return (int)(helper(zero,one,2,0,limit,dp)%mod);
    }
    public long helper(int zero,int one,int last,int count,int limit,long[][][][] dp){
        if(zero==-1 || one==-1 || count>limit){
            return 0;
        }
        if(zero==0 && one==0){
            return 1;
        }
        if(dp[zero][one][last][count]!=-1){
            return dp[zero][one][last][count];
        }
        long ways=0;
        if(last==0){
            ways=(ways+helper(zero-1,one,last,count+1,limit,dp)%mod);
        }
        else{
            ways=(ways+helper(zero-1,one,0,1,limit,dp)%mod);
        }
        if(last==1){
            ways=(ways+helper(zero,one-1,last,count+1,limit,dp)%mod);
        }
        else{
            ways=(ways+helper(zero,one-1,1,1,limit,dp)%mod);
        }
        return dp[zero][one][last][count]=ways;
    }
}