class Solution {
    public int minDays(int[] a, int m, int k) {
        int min=Arrays.stream(a).min().getAsInt();
        int max=Arrays.stream(a).max().getAsInt();
        int ans=-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(helper(a,mid,k,m)){
                ans=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return ans;
    }
    public boolean helper(int[] a,int mid,int k,int total){
        int ans=0;
        int c=0;
        for(int i=0;i<a.length;i++){
            if(mid>=a[i]){
                c++;
            }
            else{
                ans=ans+c/k;
                c=0;
            }
            if(ans>=total){
                return true;
            }
        }
        ans=ans+c/k;
        if(ans>=total){
            return true;
        }
        return false;
    }
}