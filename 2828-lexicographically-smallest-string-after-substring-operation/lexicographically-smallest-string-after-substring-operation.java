class Solution {
    public String smallestString(String s) {
        StringBuilder sb=new StringBuilder(s);
        int c=0;
        for(int i=0;i<s.length();i++){
            if(c==0 && sb.charAt(i)=='a'){
                continue;
            }
            if(c>0 && sb.charAt(i)=='a'){
                break;
            }
            sb.setCharAt(i,(char)(sb.charAt(i)-1));
            c++;
        }
        if(c>0){
            return sb.toString();
        }
        for(int i=s.length()-1;i>=0;i--){
            if(c>0 && sb.charAt(i)=='a'){
                break;
            }
            c++;
            sb.setCharAt(i,sb.charAt(i)=='a'?'z':(char)(sb.charAt(i)-1));
        }
        return sb.toString();
    }
}