class Solution {
    public int minPartitions(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'>ans){
                ans=s.charAt(i)-'0';
            }
        }
        return ans;
    }
}