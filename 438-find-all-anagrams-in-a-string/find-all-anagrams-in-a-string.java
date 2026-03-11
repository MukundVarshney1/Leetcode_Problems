class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        for(int i=0;i<p.length();i++){
            arr1[p.charAt(i)-'a']++;
        }
        int si=0;
        int ei=0;
        int c=0;
        List<Integer> ll=new ArrayList<>();
        while(si<=ei && ei<s.length()){
            arr2[s.charAt(ei)-'a']++;
            c++;
            while(si<=ei && arr2[s.charAt(ei)-'a']>arr1[s.charAt(ei)-'a']){
                arr2[s.charAt(si++)-'a']--;
                c--;
            }
            if(c==p.length()){
                ll.add(si);
            }
            ei++;
        }
        return ll;
    }
}