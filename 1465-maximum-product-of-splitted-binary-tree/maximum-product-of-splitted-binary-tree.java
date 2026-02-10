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
    long prod=0;
    long mod=1000000007;
    public int maxProduct(TreeNode root) {
        long sum=sum(root);
        helper(root,sum);
        return (int)(prod%mod);
    }
    public int helper(TreeNode root,long sum){
        if(root==null){
            return 0;
        }
        int left=helper(root.left,sum);
        int right=helper(root.right,sum);
        prod=Math.max(prod,Math.max((sum-left)*left,(sum-right)*right));
        return left+right+root.val;
    }
    public static long sum(TreeNode node){
        if(node==null){
            return 0;
        }
        return sum(node.left)+sum(node.right)+node.val;
    }
}