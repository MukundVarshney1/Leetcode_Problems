class Solution {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    static boolean[][] street = {
        {},
        {false,false,true,true}, 
        {true,true,false,false}, 
        {false,true,true,false},
        {false,true,false,true}, 
        {true,false,true,false},  
        {true,false,false,true} 
    };

    public boolean hasValidPath(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, vis);
    }

    public boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {

        int m = grid.length, n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j])
            return false;

        if (i == m - 1 && j == n - 1)
            return true;

        vis[i][j] = true;

        int type = grid[i][j];

        for (int d = 0; d < 4; d++) {

            if (!street[type][d]) continue;

            int ni = i + dirs[d][0];
            int nj = j + dirs[d][1];

            if (ni < 0 || nj < 0 || ni >= m || nj >= n)
                continue;

            int nextType = grid[ni][nj];

            int opposite = d ^ 1;
            if (street[nextType][opposite]) {
                if (dfs(grid, ni, nj, vis))
                    return true;
            }
        }

        return false;
    }
}