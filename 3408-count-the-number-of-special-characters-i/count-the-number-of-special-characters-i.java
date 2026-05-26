class Solution {
    public int numberOfSpecialChars(String s) {
        boolean[] f=new boolean[128];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                f[s.charAt(i)-'A']=true;
            }
            else{
                f[s.charAt(i)-'a'+26]=true;
            }
        }
        int c=0;
        for(int i=0;i<26;i++){
            if(f[i] && f[i+26]){
                c++;
            }
        }
        return c;
    }
}