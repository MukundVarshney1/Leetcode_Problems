class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sum+=grid[i][j];
            }
        }
        if(sum%2!=0){
            return false;
        }
        long rsum=0;
        for(int i=0;i<grid.length;i++){
            if(rsum*2>sum){
                break;
            }
            for(int j=0;j<grid[0].length;j++){
                rsum+=grid[i][j];
            }
            if(rsum*2==sum){
                return true;
            }
        }
        long csum=0;
        for(int i=0;i<grid[0].length;i++){
            if(csum*2>sum){
                break;
            }
            for(int j=0;j<grid.length;j++){
                csum+=grid[j][i];
            }
            if(csum*2==sum){
                return true;
            }
        }
        return false;
    }
}