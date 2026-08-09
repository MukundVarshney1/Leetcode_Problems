class Solution {
    public double minPrice(int[] p, int[] d) {
        Arrays.sort(p);
        Arrays.sort(d);
        int i=p.length-1;
        int j=d.length-1;
        double ans=0;
        while(i>=0 && j>=0){
            ans+=(1.0*p[i--]*(100-d[j--])/100);
        }
        while(i>=0){
            ans+=p[i--];
        }
        return ans;
    }
}