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
    public TreeNode bstToGst(TreeNode root) {
       helper(root,root.val);
       return root; 
    }
    public int helper(TreeNode root,int val){
        if(root==null){
            return 0;
        }
        int right=helper(root.right,val);
        root.val+=right;
        if(root.val<val){
            root.val+=val;
        }
        int left=helper(root.left,root.val);
        return Math.max(root.val,Math.max(left,right));
    }
}