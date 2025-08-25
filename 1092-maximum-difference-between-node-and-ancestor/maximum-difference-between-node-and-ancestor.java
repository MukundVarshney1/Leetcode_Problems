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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root,root.val,root.val);
        return ans;
    }
    public void helper(TreeNode root,int min,int max){
        if(root==null){
            return;
        }
        ans=Math.max(ans,Math.max(Math.abs(min-root.val),Math.abs(max-root.val)));
        min=Math.min(min,root.val);
        max=Math.max(max,root.val);
        helper(root.left,min,max);
        helper(root.right,min,max);
    }
}