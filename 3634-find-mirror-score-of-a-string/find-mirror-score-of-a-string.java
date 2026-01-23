class Solution {
    public long calculateScore(String s) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), k -> new TreeSet<>()).add(i);
        }

        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char mirror = (char) ('a' + 'z' - c);

            TreeSet<Integer> set = map.get(mirror);
            if (set != null) {
                Integer x = set.floor(i - 1);
                if (x != null) {
                    set.remove(x);
                    ans += Math.abs(i - x);
                    map.get(c).remove(i);
                }
            }
        }

        return ans;
    }
}
