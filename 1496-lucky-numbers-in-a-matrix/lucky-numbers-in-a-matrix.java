class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int row=0;row<n;row++){
            int c=Integer.MAX_VALUE;
            int idx=-1;
            for(int i=0;i<m;i++){
                if(matrix[row][i]<c){
                    c=matrix[row][i];
                    idx=i;
                }
            }
            int f=0;
            for(int i=0;i<n;i++){
                if(matrix[i][idx]>c){
                    f=1;
                    break;
                }
            }
            if(f==0){
                ans.add(c);
            }
        }
        return ans;
    }
}