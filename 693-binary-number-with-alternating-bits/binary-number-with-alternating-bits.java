class Solution {
    public boolean hasAlternatingBits(int n) {
        int f=(n&1);
        while(n>0){
            int rem=(n&1);
            if(rem==0){
                if(f!=0){
                    return false;
                }
                f=1;
            }
            else{
                if(f!=1){
                    return false;
                }
                f=0;
            }
            n>>=1;
        }
        return true;
    }
}