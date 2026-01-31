class Solution {
    public char nextGreatestLetter(char[] l, char t) {
        int lo=0;
        int hi=l.length-1;
        char ans=l[0];
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(l[mid]>t){
                ans=l[mid];
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}