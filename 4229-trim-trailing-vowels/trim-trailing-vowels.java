class Solution {
    public String trimTrailingVowels(String s) {
        int e=s.length()-1;
        for(;e>=0;e--){
            if(check(s,e)){
                break;
            }
        }
        if(e==-1){
            return "";
        }
        return s.substring(0,e+1);
    }
    public static boolean check(String s,int i){
        if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
            return false;
        }
        return true;
    }
}