class Solution {
    public int maxRepeating(String sequence, String word) {
        String s="";
        int c=-1;
        while(sequence.indexOf(s)!=-1){
            c++;
            s+=word;
        }
        return c;
    }
}