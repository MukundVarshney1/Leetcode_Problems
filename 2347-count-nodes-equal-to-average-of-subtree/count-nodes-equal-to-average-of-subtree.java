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
    public int averageOfSubtree(TreeNode root) {
        return helper(root).ans;
    }
    public pair helper(TreeNode root){
        if(root==null){
            return new pair();
        }
        pair left=helper(root.left);
        pair right=helper(root.right);
        int sum=left.sum+right.sum+root.val;
        int n=left.n+right.n+1;
        int avg=Math.round(sum/n);
        pair self=new pair();
        self.sum=sum;
        self.n=n;
        self.ans=left.ans+right.ans;
        if(avg==root.val){
            self.ans=left.ans+right.ans+1;
        }
        return self;
    }
    class pair{
        int n=0;
        int ans=0;
        int sum=0;
    }
}