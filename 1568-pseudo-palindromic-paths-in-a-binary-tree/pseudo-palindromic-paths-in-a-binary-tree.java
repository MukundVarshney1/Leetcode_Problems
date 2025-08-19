/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] digits=new int[9];
        helper(root,digits);
        return ans;
    }
    public void helper(TreeNode root,int[] digits){
        if(root==null){
            return;
        }
        digits[root.val-1]++;
        helper(root.left,digits);
        helper(root.right,digits);
        if(root.left==null && root.right==null){
            int od=odd(digits);
            if(od<=1){
                ans++;
            }
        }
        digits[root.val-1]--;
    }
    public int odd(int[] digits){
        int od=0;
        for(int i=0;i<9;i++){
            if(digits[i]%2!=0){
                od++;
            }
        }
        return od;
    }
}