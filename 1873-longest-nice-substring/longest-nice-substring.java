class Solution {
    public String longestNiceSubstring(String s) {
        int c=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                int x=helper(s.substring(i,j));
                if(x>c){
                    c=x;
                    ans=s.substring(i,j);
                }
            }
        }
        return ans;
    }
    public int helper(String s){
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=65 && s.charAt(i)<=92){
                if(!set.contains((char)(s.charAt(i)+32))){
                    return 0;
                }
            }
            else if(s.charAt(i)>=97 && s.charAt(i)<=122){
                if(!set.contains((char)(s.charAt(i)-32))){
                    return 0;
                }
            }
        }
        return s.length();
    }
}