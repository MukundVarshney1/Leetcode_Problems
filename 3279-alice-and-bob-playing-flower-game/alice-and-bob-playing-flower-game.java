class Solution {
    public long flowerGame(int n, int m) {
        long ans=0;
        long a=n/2+n%2;
        long b=n/2;
        long c=m/2+m%2;
        long d=m/2;
        ans=ans+(a*d)+(b*c);
        return ans;
    }
}