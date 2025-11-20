class Solution {
    public int minimumArea(int[][] grid) {
        int x1=-1;
        int x2=-1;
        int y1=-1;
        int y2=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(x1==-1){
                        x1=i;
                        x2=i;
                        y1=j;
                        y2=j;
                        continue;
                    }
                    x1=Math.min(x1,i);
                    x2=Math.max(x2,i);
                    y1=Math.min(y1,j);
                    y2=Math.max(y2,j);
                }
            }
        }
        return (x2-x1+1)*(y2-y1+1);
    }
}