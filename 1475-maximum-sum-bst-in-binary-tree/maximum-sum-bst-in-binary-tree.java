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
    public class pair{
        boolean isbst=true;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;
        int msum;
    }
    public int maxSumBST(TreeNode root) {
        pair p=helper(root);
        return p.msum;
    }
    public pair helper(TreeNode node){
        if(node==null){
            return new pair();
        }
        pair left=helper(node.left);
        pair right=helper(node.right);
        if(left.isbst && right.isbst && node.val>left.max && node.val<right.min){
            int min=Math.min(node.val,Math.min(left.min,right.min));
            int max=Math.max(node.val,Math.max(left.max,right.max));
            int sum=left.sum+right.sum+node.val;
            left.min=min;
            left.max=max;
            left.msum=Math.max(left.msum,Math.max(right.msum,sum));
            left.sum=sum;
        }
        else{
            left.isbst=false;
            left.max=Math.max(left.max,right.max);
            left.min=Math.min(left.min,right.min);
            left.msum=Math.max(left.msum,right.msum);
        }
        return left;
    }
}