class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si=0;
        int ei=0;
        int[] freq=new int[128];
        int ans=0;
        while(si<=ei && ei<s.length()){
            freq[s.charAt(ei)]++;
            if(freq[s.charAt(ei)]>1){
                while(si<=ei && freq[s.charAt(ei)]>1){
                    freq[s.charAt(si)]--;
                    si++;
                }
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}