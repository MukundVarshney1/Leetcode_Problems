class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        Queue<pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new pair(i, j,0));
                }
            }
        }
        while (!q.isEmpty()) {
            pair qp = q.poll();
            helper(grid, qp.i - 1, qp.j, q,qp.ans);
            helper(grid, qp.i + 1, qp.j, q,qp.ans);
            helper(grid, qp.i, qp.j - 1, q,qp.ans);
            helper(grid, qp.i, qp.j + 1, q,qp.ans);
            ans = qp.ans;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public void helper(int[][] g, int i, int j, Queue<pair> q,int ans) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length) {
            return;
        }
        if (g[i][j] == 1) {
            q.add(new pair(i, j,ans+1));
            g[i][j]=2;
        }

    }

    class pair {
        int i;
        int j;
        int ans = 0;

        pair(int a, int b,int ans) {
            this.i = a;
            this.j = b;
            this.ans=ans;
        }
    }
}