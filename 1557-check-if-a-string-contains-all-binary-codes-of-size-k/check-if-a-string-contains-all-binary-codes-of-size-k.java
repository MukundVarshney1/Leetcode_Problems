class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            String a="";
            for(int j=i;j<i+k;j++){
                a+=s.charAt(j);
            }
            set.add(a);
        }
        return set.size()==(int)Math.pow(2,k);
    }
}