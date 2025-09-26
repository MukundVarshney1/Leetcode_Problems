class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n=nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = map.lastKey();
        for (int i = k; i < n; i++) {
            int rem = nums[i - k];
            map.put(rem, map.get(rem) - 1);
            if (map.get(rem) == 0) {
                map.remove(rem);
            }
            int add = nums[i];
            map.put(add, map.getOrDefault(add, 0) + 1);
            ans[i - k + 1] = map.lastKey();
        }

        return ans;
    }
}