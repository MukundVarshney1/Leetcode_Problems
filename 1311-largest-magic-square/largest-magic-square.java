class Solution {
    public int largestMagicSquare(int[][] grid) {
        int ans = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = ans; k < Math.min(grid.length - i, grid[0].length - j); k++) {
                    if (isitposs(grid, i, j, k)) {
                        ans = Math.max(ans, k + 1);
                    }
                }
            }
        }
        return ans;
    }

    public boolean isitposs(int[][] grid, int a, int b, int c) {
        int psum = -1;
        for (int i = a; i <= c + a; i++) {
            int sum = 0;
            for (int j = b; j <= c + b; j++) {
                sum += grid[i][j];
            }
            if (psum == -1) {
                psum = sum;
            } else {
                if (psum != sum) {
                    return false;
                }
            }
        }
        for (int j = b; j <= b + c; j++) {
            int sum = 0;
            for (int i = a; i <= a + c; i++) {
                sum += grid[i][j];
            }
            if (psum != sum)
                return false;
        }
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i <= c; i++) {
            d1 += grid[a + i][b + i];
            d2 += grid[a + i][b + c - i];
        }
        if (psum != d1 || psum != d2) {
            return false;
        }
        return true;
    }
}