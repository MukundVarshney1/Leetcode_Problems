class Solution {
    public int canBeTypedWords(String text, String bl) {
        int ans=0;
        int k=0;
        int n=text.length();
        for(int i=0;i<n+1;i++){
            if(i==n || text.charAt(i)==' '){
                ans+=helper(text.substring(k,i),bl);
                k=i+1;
            }
        }
        return ans;
    }
    public static int helper(String s,String str){
        for(int i=0;i<s.length();i++){
            for(int j=0;j<str.length();j++){
                if(s.charAt(i)==str.charAt(j)){
                    return 0;
                }
            }
        }
        return 1;
    }
}