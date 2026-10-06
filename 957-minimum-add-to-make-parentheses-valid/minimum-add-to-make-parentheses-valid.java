class Solution {
    public int minAddToMakeValid(String s) {
        int c=0;
        int f=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                c++;
            }
            else if(c>0 && s.charAt(i)==')'){
                c--;
            }
            else{
                f++;
            }
        }
        return Math.abs(c)+f;
    }
}