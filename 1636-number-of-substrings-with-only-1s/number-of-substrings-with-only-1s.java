class Solution {
    public int numSub(String s) {
        long ans = 0;
        int c = 0;
        long mod = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                c++;
            } else {
                ans = (ans + (long)c * (c + 1) / 2) % mod;
                c = 0;
            }
        }

        ans = (ans + (long)c * (c + 1) / 2) % mod;
        return (int) ans;
    }
}
