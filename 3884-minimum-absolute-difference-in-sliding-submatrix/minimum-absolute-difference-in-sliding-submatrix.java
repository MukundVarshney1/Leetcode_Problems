class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] ans=new int[grid.length-k+1][grid[0].length-k+1];
        for(int i=0;i<grid.length-k+1;i++){
            for(int j=0;j<grid[0].length-k+1;j++){
                int diff=Integer.MAX_VALUE;
                for(int a=i;a<i+k;a++){
                    for(int b=j;b<j+k;b++){
                        int ele=grid[a][b];
                        for(int x=i;x<i+k;x++){
                            for(int y=j;y<j+k;y++){
                                if (grid[x][y] == ele) continue;
                                diff=Math.min(diff,Math.abs(ele-grid[x][y]));
                            }
                        }
                    }
                }
                ans[i][j]=diff!=Integer.MAX_VALUE?diff:0;
            }
        }
        return ans;
    }
}