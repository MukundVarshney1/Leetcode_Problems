class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int buy=prices[0];
        int c=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                buy=prices[i];
                ans+=c;
                c=0;
            }
            else{
                c=Math.max(c,prices[i]-buy);
            }
        }
        return ans+c;
    }
}