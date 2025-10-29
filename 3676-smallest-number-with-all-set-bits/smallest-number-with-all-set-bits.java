class Solution {
    public int smallestNumber(int n) {
        int ans=0;
        int lo=0;
        int hi=10;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(Math.pow(2,mid)>n){
                ans=(int)Math.pow(2,mid)-1;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}