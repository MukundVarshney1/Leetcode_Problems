class Solution {
    public boolean checkOnesSegment(String s) {
        int c=0;
        int f=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(f==0){
                    c++;
                    f=1;
                }
            }
            else{
                f=0;
            }
            if(c>1){
                return false;
            }
        }
        return true;
    }
}