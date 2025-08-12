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
    int m=0;
    int ans;
    public int findBottomLeftValue(TreeNode root) {
        helper(root,1);
        return ans;
    }
    public void helper(TreeNode root,int i){
        if(root==null){
            return;
        }
        if(i>m){
            m=i;
            ans=root.val;
        }
        helper(root.left,i+1);
        helper(root.right,i+1);
    }
}