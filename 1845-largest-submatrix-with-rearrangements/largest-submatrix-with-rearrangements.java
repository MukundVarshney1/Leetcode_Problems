class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int ans=0;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col]==1 && row>0){
                    matrix[row][col]+=matrix[row-1][col];
                }
            }
            int[] rowheight=matrix[row].clone();
            Arrays.sort(rowheight);
            for(int col=0;col<rowheight.length;col++){
                ans=Math.max(ans,rowheight[col]*(rowheight.length-col));
            }
        }
        return ans;
    }
}