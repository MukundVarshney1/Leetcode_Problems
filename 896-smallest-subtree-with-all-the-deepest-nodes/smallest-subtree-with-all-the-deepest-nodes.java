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
    TreeNode ans=null;
    int maxdepth=0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root,0);
        return ans;
    }
    public int helper(TreeNode root,int depth){
        if(root==null){
            maxdepth=Math.max(maxdepth,depth);
            return depth;
        }
        int left=helper(root.left,depth+1);
        int right=helper(root.right,depth+1);
        if(left==right && right==maxdepth){
            ans=root;
        }
        return Math.max(left,right);
    }
}