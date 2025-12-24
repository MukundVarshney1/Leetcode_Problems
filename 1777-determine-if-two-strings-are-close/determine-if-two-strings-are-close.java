class Solution {
    public boolean closeStrings(String w1, String w2) {
        if(w1.length()!=w2.length()){
            return false;
        }
        int[] f1=new int[26];
        int[] f2=new int[26];
        for(int i=0;i<w1.length();i++){
            f1[w1.charAt(i)-'a']++;
        }
        for(int i=0;i<w2.length();i++){
            if(f1[w2.charAt(i)-'a']==0){
                return false;
            }
            f2[w2.charAt(i)-'a']++;
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]){
                return false;
            }
        }
        return true;
    }
}