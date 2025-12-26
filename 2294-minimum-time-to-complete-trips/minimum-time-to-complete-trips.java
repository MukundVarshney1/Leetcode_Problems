class Solution {
    public long minimumTime(int[] time, int tt) {
        long lo=0;
        long hi = (long) Arrays.stream(time).min().getAsInt() * tt;
        long ans=hi;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isval(time,mid,tt)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public boolean isval(int[] time,long have,int target){
        long a=0;
        for(int i=0;i<time.length;i++){
            a+=have/time[i];
            if(a>=target){
                return true;
            }
        }
        return false;
    }
}