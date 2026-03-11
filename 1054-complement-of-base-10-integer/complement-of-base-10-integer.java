class Solution {
    public int bitwiseComplement(int n) {
        return n==0?1:n^(int)(Math.pow(2,(int)(Math.log(n)/Math.log(2)+1))-1);
    }
}