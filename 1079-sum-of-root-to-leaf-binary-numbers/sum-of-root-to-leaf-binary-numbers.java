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
    public int sumRootToLeaf(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode node,int val){
        if(node==null)      return 0;
        if(node.left==null && node.right==null)     return val*2+node.val;
        return helper(node.left,val*2+node.val)+helper(node.right,val*2+node.val);
    }
}