class Solution {
    public int maxDistance(int s, int[][] p, int k) {
        int n = p.length;
        long[] arr = new long[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = getPerimeterDist(p[i], s);
        }
        Arrays.sort(arr, 0, n);
        long perimeter = 4L * s;
        for (int i = 0; i < n; i++) {
            arr[i + n] = arr[i] + perimeter;
        }
        int lo = 0;
        int hi = s;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (helper(arr, n, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean helper(long[] arr, int n, int k, int d) {
        for (int i = 0; i < n; i++) {
            int c = 1;
            int currIdx = i;
            while (c < k) {
                long target = arr[currIdx] + d;
                int lo = currIdx + 1;
                int hi = i + n - 1;
                int nextIdx = -1;
                
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (arr[mid] >= target) {
                        nextIdx = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                if (nextIdx != -1) {
                    c++;
                    currIdx = nextIdx;
                } else {
                    break;
                }
            }
            if (c >= k && (arr[i + n] - arr[currIdx] >= d)) {
                return true;
            }
        }
        return false;
    }

    private long getPerimeterDist(int[] p, int s) {
        int x = p[0], y = p[1];
        if (y == 0)
            return x;
        if (x == s)
            return (long) s + y;
        if (y == s)
            return 2L * s + (s - x);
        return 3L * s + (s - y);
    }
}