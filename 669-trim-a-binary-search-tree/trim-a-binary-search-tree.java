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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        TreeNode a=trimBST(root.left,low,high);
        TreeNode b=trimBST(root.right,low,high);
        root.left=a;
        root.right=b;
        if(root.val>=low && root.val<=high){
            return root;
        }
        if(root.left==null){
            return b;
        }
        return a;
    }
}