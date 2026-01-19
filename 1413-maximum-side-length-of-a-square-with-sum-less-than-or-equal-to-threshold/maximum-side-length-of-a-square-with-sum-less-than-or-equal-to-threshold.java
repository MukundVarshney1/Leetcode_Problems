class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] cSum=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            cSum[i][0]+=mat[i][0];
            if(i>0){
                cSum[i][0]+=cSum[i-1][0];
            }
        }
        for(int i=1;i<mat[0].length;i++){
            cSum[0][i]+=mat[0][i]+cSum[0][i-1];
        }
        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                cSum[i][j]=mat[i][j]+cSum[i-1][j]+cSum[i][j-1]-cSum[i-1][j-1];
            }
        }
        int ans=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                for(int k=ans;k<Math.min(mat.length-i,mat[0].length-j);k++){
                    int sum=cSum[i+k][j+k];
                    if(i>0){
                        sum-=cSum[i-1][j+k];
                    }
                    if(j>0){
                        sum-=cSum[i+k][j-1];
                    }
                    if(i>0 && j>0){
                        sum+=cSum[i-1][j-1];
                    }
                    if(sum<=threshold){
                        ans=Math.max(ans,k+1);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return ans;
    }
}