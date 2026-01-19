class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int j=0;
        int p=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                p++;
            }
            else{
                p--;
            }
            if(p==0){
                ans+=s.substring(j+1,i);
                j=i+1;
            }
        }
        return ans;
    }
}