class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            long a = queries[i][0];
            long b = queries[i][1];
            int length = 0;
            
            while (a != b) {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
                length++;
            }
            
            ans[i] = length + 1;
        }
        
        return ans;
    }
}