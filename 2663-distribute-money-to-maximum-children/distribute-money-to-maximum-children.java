class Solution {
    public int distMoney(int money, int children) {
        if(money<children){
            return -1;
        }
        if(money==children){
            return 0;
        }
        money-=children;
        int ans=money/7;
        if(ans>children ||(ans==children && money%7!=0)){
            return children-1;
        }
        if(money%7==3 && ans==children-1){
            ans--;
        }
        return ans;
    }
}