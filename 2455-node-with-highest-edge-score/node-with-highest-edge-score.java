class Solution {
    public int edgeScore(int[] edges) {
        long[] ans=new long[edges.length];
        for(int i=0;i<edges.length;i++){
            ans[edges[i]]+=i;
        }
        long max=0;
        int idx=0;
        for(int i=0;i<ans.length;i++){
            if(ans[i]>max){
                max=ans[i];
                idx=i;
            }
        }
        return idx;
    }
}