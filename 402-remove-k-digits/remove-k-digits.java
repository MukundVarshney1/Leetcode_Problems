class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num.length();i++){
            while(k!=0 && sb.length()!=0 && num.charAt(i)<sb.charAt(sb.length()-1)){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(num.charAt(i));
        }
        while(k-->0){
            sb.deleteCharAt(sb.length()-1);
        }
        String s=sb.toString();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                return s.substring(i);
            }
        }
        return "0";
    }
}