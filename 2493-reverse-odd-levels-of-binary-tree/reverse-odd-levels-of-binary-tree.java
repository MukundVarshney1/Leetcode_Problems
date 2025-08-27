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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root.left==null || root.right==null){
            return root;
        }
        helper(root.left,root.right,1);
        return root;
    }
    public void helper(TreeNode root1,TreeNode root2,int idx){
        if(root1==null ||root2==null){
            return ;
        }
        if(idx%2==1){
            int temp=root1.val;
            root1.val=root2.val;
            root2.val=temp;
        }
        helper(root1.left,root2.right,idx+1);
        helper(root2.left,root1.right,idx+1);

    }
}