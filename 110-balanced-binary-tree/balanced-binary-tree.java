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
    boolean ans=true;
    public boolean isBalanced(TreeNode root) {
        helper(root,0);
        return ans;
    }
    public int helper(TreeNode root,int i){
        if(root==null){
            return 0;
        }
        int x=helper(root.left,i);
        int y=helper(root.right,i);
        if(Math.abs(x-y)>1){
            ans=false;
        }
        return Math.max(x,y)+1;
    }
}