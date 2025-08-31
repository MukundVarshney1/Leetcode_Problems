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
    int md=0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root,0);
        return ans;
    }
    public void helper(TreeNode root,int d){
        if(root==null){
            return;
        }
        helper(root.left,d+1);
        helper(root.right,d+1);
        if(md==d){
            ans+=root.val;
            return;
        }
        else if(d>md){
            ans=root.val;
        }
        md=Math.max(md,d);
    }
}