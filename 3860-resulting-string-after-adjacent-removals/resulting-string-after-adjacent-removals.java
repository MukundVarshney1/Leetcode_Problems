class Solution {
    public String resultingString(String s) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int size=str.length();
            if(size>0 && x(str.charAt(size-1),s.charAt(i))){
                str.deleteCharAt(str.length()-1);
            }
            else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
    public static boolean x(char p,char q){
        int g=Math.abs(p-q);
        return g==1 || g==25?true:false;
    }
}