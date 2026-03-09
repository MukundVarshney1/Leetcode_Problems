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
    public boolean isUnivalTree(TreeNode root) {
        return helper(root,root.val);
    }
    public static boolean helper(TreeNode root,int val){
        if(root==null){
            return true;
        }
        boolean l=helper(root.left,val);
        boolean r=helper(root.right,val);
        return l && r && root.val==val;
    }
}