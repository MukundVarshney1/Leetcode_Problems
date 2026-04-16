class Solution {
    public List<Integer> solveQueries(int[] nums, int[] q) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int idx : q) {
            List<Integer> list = map.get(nums[idx]);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int lo = 0, hi = list.size() - 1;
            int pos = -1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (list.get(mid) == idx) {
                    pos = mid;
                    break;
                } else if (list.get(mid) < idx) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            int nextIndex = list.get((pos + 1) % list.size());
            int prevIndex = list.get((pos - 1 + list.size()) % list.size());

            int distNext = nextIndex > idx
                    ? nextIndex - idx
                    : n - idx + nextIndex;

            int distPrev = idx > prevIndex
                    ? idx - prevIndex
                    : idx + n - prevIndex;

            ans.add(Math.min(distNext, distPrev));
        }

        return ans;
    }
}