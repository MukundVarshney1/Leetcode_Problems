class Solution {
    public long largestSquareArea(int[][] a, int[][] b) {
        long ans = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int left   = Math.max(a[i][0], a[j][0]);
                int bottom = Math.max(a[i][1], a[j][1]);
                int right  = Math.min(b[i][0], b[j][0]);
                int top    = Math.min(b[i][1], b[j][1]);

                if (right > left && top > bottom) {
                    ans=Math.max(ans, Math.min(right - left, top - bottom));
                }
            }
        }
        return ans*ans;
    }
}
