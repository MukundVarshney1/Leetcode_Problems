class Solution {
    public char[][] rotateTheBox(char[][] b) {
        char[][] ans = new char[b[0].length][b.length];
        for(char[] a:ans){
            Arrays.fill(a,'.');
        }
        int r = 0;
        int c = b.length - 1;
        for (int i = 0; i < b.length; i++) {
            int co = 0;
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == '#') {
                    co++;
                } else if (b[i][j] == '*') {
                    int temp = j-1;
                    while (co > 0) {
                        ans[temp][c] = '#';
                        co--;
                        temp--;
                    }
                    r = j;
                    ans[r][c]='*';
                }
            }
            int temp=b[0].length-1;
            while (co > 0) {
                ans[temp][c] = '#';
                co--;
                temp--;
            }
            c--;
        }
        return ans;
    }
}