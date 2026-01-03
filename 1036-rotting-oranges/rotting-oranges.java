class Solution {
    public int orangesRotting(int[][] grid) {
       int m=0;
       int f=0;
       Queue<pair> q=new LinkedList<>();
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1){
                f++;
            }
        }
       }
        while(f>0){
            int c=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1){
if(helper(grid,i-1,j,i,j,q) || helper(grid,i+1,j,i,j,q) || helper(grid,i,j-1,i,j,q) || helper(grid,i,j+1,i,j,q)){
    c++;
}
                    }
                }
            }
            if(c==0){
                return -1;
            }
            while(!q.isEmpty()){
                pair x=q.poll();
                grid[x.a][x.b]=2;
            }
            f-=c;
            m++;
        }
        return m;
    }
    public boolean helper(int[][] grid,int i,int j,int a,int b,Queue<pair> q){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length){
            return false;
        }
        if(grid[i][j]==2){
           q.add(new pair(a,b));
           return true;
        }
        return false;
    }
    public class pair{
        int a;
        int b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
}