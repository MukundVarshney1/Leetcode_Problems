class Solution {
    public int maxProfit(int[] p) {
     int buy=p[0];
     int ans=0;
     for(int i=0;i<p.length;i++){
        if(p[i]<buy){
            buy=p[i];
        }
        else{
            ans=Math.max(ans,p[i]-buy);
        }
     }
     return ans;   
    }
}