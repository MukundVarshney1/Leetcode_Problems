class Solution {
    public int numberOfSpecialChars(String w) {
        int[] firstLower = new int[26];
        int[] firstUpper = new int[26];
        int[] lastLower  = new int[26];

        Arrays.fill(firstLower, -1);
        Arrays.fill(firstUpper, -1);

        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                if (firstLower[idx] == -1) {
                    firstLower[idx] = i;
                }
                lastLower[idx] = i;
            } else {
                int idx = ch - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (firstLower[i] != -1 &&
                firstUpper[i] != -1 &&
                lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        return count;
    }
}