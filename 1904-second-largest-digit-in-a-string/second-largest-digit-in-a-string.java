class Solution {
    public int secondHighest(String s) {
        int m=0;
        int sm=0;
        for(char ch='9';ch>='0';ch--){
            if(m==1 && s.indexOf(ch)!=-1){
                return ch-'0';
            }
            if(s.indexOf(ch)!=-1){
                m=1;
            }
        }
        return -1;
    }
}