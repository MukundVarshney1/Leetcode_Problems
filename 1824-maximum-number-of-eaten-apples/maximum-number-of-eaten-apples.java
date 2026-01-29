class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int[][] a = new int[apples.length][2];
        for (int i = 0; i < apples.length; i++) {
            a[i][0] = apples[i];
            a[i][1] = i + days[i];
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((x, y) -> x[1] - y[1]);

        int ans = 0;
        long day = 0;
        int i = 0;

        while (i < a.length || !pq.isEmpty()) {
            if (i < a.length) {
                pq.add(a[i]);
            }

            while (!pq.isEmpty() &&
                  (pq.peek()[1] <= day || pq.peek()[0] <= 0)) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.peek()[0]--;
                ans++;
            }

            day++;
            i++;
        }

        return ans;
    }
}
