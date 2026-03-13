class Solution {
    public long minNumberOfSeconds(int h, int[] w) {
        long lo=0;
        long hi=(long)Arrays.stream(w).max().getAsInt()*((long)h*(h+1)/2);
        long ans=hi;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(check(mid,w,h)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    boolean check( long mid, int[] workerTimes, int mountainHeight ) {
        long h = 0; 

        for( int t : workerTimes ) {
            h += (long) ( Math.sqrt( 2.0 * mid / t + 0.25 ) - 0.5 );

            if( h >= mountainHeight ) {
                return true;
            }
        }

        return h >= mountainHeight;

    }
}