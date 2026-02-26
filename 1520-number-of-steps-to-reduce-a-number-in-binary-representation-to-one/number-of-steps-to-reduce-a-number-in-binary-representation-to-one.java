class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        int ans = 0;
        for (int i = 0; i < sb.length() - 1;) {
            if (sb.charAt(i) == '1') {
                int j = i;
                int f = 0;
                while (j < sb.length()) {
                    if (sb.charAt(j) == '0') {
                        sb.setCharAt(j, '1');
                        f = 1;
                        break;
                    } else {
                        sb.setCharAt(j, '0');
                    }
                    j++;
                }
                if (f == 0) {
                    sb.append('1');
                }
            } else {
                i++;
            }
            ans++;
        }
        return ans;
    }
}