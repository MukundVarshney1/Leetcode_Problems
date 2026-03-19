class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int[][] mat=new int[grid.length][grid[0].length];
        int[][] x=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='X'){
                    x[i][j]=1;
                    mat[i][j]=1;
                }
                else if(grid[i][j]=='Y'){
                    mat[i][j]=-1;
                }
                else{
                    mat[i][j]=0;
                }
            }
        } 
        for(int i=1;i<grid.length;i++){
            x[i][0]+=x[i-1][0];
            mat[i][0]+=mat[i-1][0];
        }
        for(int i=1;i<grid[0].length;i++){
            x[0][i]+=x[0][i-1];
            mat[0][i]+=mat[0][i-1];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                mat[i][j]+=mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1];
                 x[i][j]+=x[i-1][j]+x[i][j-1]-x[i-1][j-1];
            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(mat[i][j]==0 && x[i][j]>0){
                    ans++;
                }
            }
        }
        return ans;
    }
}