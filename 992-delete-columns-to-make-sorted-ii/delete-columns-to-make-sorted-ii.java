class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        char[][] a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = strs[i].toCharArray();
        }
        boolean[] already = new boolean[n - 1];
        int unresolved = n - 1;
        int deletions = 0;
        for (int col = 0; col < m && unresolved > 0; col++) {
            boolean flag = false;
            for (int row = 0; row < n - 1; row++) {
                if (!already[row] && a[row][col] > a[row + 1][col]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                deletions++;
                continue;
            }
            for (int row = 0; row < n - 1; row++) {
                if (!already[row] && a[row][col] < a[row + 1][col]) {
                    already[row] = true;
                    unresolved--;
                }
            }
        }

        return deletions;
    }
}