class Solution {
    public long maxMatrixSum(int[][] mat) {
        long ans=0;
        int min=Integer.MAX_VALUE;
        int neg=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(mat[i][j]<0){
                    neg++;
                }
                ans+=Math.abs(mat[i][j]);
                min=Math.min(min,Math.abs(mat[i][j]));
            }
        }
        if(neg%2==0){
            return ans;
        }
        return ans-2*min;
    }
}