class Solution {
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        //        int mask=xor&(~(xor-1));         (~(xor-1)=-1*xor
        int mask = xor & (-1*xor);
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & nums[i]) != 0) {
                a ^= nums[i];
            }
        }
        int b = xor ^ a;
        return new int[] { a, b };
    }
}