class Solution {
    public boolean doesAliceWin(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(isvow(s.charAt(i))){
                ans++;
            }
        }
        if(ans==0){
            return false;
        }
        return true;
    }
    public boolean isvow(char ch){
        return ch=='a' || ch=='e'||ch=='i'||ch=='o' ||ch=='u' || ch=='A'||ch=='E'||ch=='I' ||ch=='O' || ch=='U';
    }
}