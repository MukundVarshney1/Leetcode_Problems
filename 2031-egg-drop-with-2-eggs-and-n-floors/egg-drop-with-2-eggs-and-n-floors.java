class Solution {
    public int twoEggDrop(int n) {
        int c=0;
        int m=0;
        while(c<n){
            m++;
            c+=m;
        }
        return m;
    }
}