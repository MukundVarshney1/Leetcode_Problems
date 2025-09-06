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
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root,0,0);
    }
    public int helper(TreeNode root,int gp,int p){
        if(root==null){
            return 0;
        }
        int left=helper(root.left,p,root.val);
        int right=helper(root.right,p,root.val);
        int ans=left+right;
        if(gp%2==0 && gp!=0){
            ans+=root.val;
        }
        return ans;
        
    }
}