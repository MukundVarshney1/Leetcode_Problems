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
    public int goodNodes(TreeNode root) {
        return helper(root,root.val-1);
    }
    public int helper(TreeNode root,int max){
        if(root==null){
            return 0;
        }
        int left=helper(root.left,Math.max(max,root.val));
        int right=helper(root.right,Math.max(max,root.val));
        if(root.val>=max){
            return left+right+1;
        }
        return left+right;
    }
}