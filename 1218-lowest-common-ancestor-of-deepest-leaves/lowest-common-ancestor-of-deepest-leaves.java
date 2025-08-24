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
    TreeNode result;
    int maxdepth=0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root,0);
        return result;
    }
    public int helper(TreeNode root,int depth){
        if(root==null){
            maxdepth=Math.max(maxdepth,depth);
            return depth;
        }
        int l=helper(root.left,depth+1);
        int r=helper(root.right,depth+1);
        if(l==r && l==maxdepth){
            result=root;
        }
        return Math.max(l,r);
    }
}