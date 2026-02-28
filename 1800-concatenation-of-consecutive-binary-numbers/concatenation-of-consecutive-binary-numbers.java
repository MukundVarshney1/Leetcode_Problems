class Solution {
    public int concatenatedBinary(int n) {
        long ans=0;
        long mod=1000000007;
        for(int i=1;i<=n;i++){
            int len=(int)(Math.log(i)/Math.log(2))+1;
            ans=((ans<<len)+i)%mod;
        }
        return (int)ans;
    }
}