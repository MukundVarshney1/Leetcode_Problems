class Solution {
    int i=0;
    public String decodeString(String s) {
        return helper(s,0);
    }
    public String helper(String s,int c){
        int l=0;
        StringBuilder str=new StringBuilder();
        for(;i<s.length();i++){
            if(s.charAt(i)==']'){
                String ss=str.toString();
                for(int j=1;j<c;j++){
                    str.append(ss);
                }
                return str.toString();
            }
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                l=l*10+s.charAt(i)-'0';
            }
            else if(s.charAt(i)=='['){
                i++;
                str.append(helper(s,l));
                l=0;
            }
            else{
                str.append(s.charAt(i));
            }
        }
        // String ss=str.toString();
        // for(int j=1;j<c;j++){
        //     str.append(ss);
        // }
        return str.toString();
    }
}