class Solution {
    final int mod = 1_000_000_007;
    public int numWays(String s) {
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                c++;
            }
        }
        if(c%3!=0){
            return 0;
        }
         if (c == 0) {
            long gaps = s.length() - 1;
            return (int)((gaps * (gaps - 1) / 2) % mod);
        }
        int ans=1;
        c=c/3;
        int count=0;
        long range=0;
        int f=0;
        for(int i=0;i<s.length();i++){
            if(f==2){
                break;
            }
            if(s.charAt(i)=='1'){
                count++;
            }
            if(count>c){
                f++;
                count=1;
                ans=(int)((ans * range) % mod);
                range=0;
            }
            if(count==c){
                range++;
            }
        }
        return ans;
    }
}