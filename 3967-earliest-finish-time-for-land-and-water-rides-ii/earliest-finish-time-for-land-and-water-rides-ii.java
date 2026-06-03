class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        return Math.min(
            helper(ls,ld,ws,wd),
            helper(ws,wd,ls,ld)
        );
    }
    private int helper(int[] ls, int[] ld,int[] ws, int[] wd) {
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < ls.length; i++) {
            mini = Math.min(mini, ls[i] + ld[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < ws.length; i++) {
            ans = Math.min(
                ans,
                Math.max(mini, ws[i]) + wd[i]
            );
        }
        return ans;
    }
}