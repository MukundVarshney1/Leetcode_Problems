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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int st,int ed){
        if(st>ed){
            return null;
        }
        int idx=max(nums,st,ed);
        TreeNode root=new TreeNode(nums[idx]);
        root.left=helper(nums,st,idx-1);
        root.right=helper(nums,idx+1,ed);
        return root;
    }
    public int max(int[]nums,int st,int ed){
        int max=nums[st];
        int idx=st;
        for(int i=st+1;i<=ed;i++){
            if(nums[i]>max){
                max=nums[i];
                idx=i;
            }
        }
        return idx;
    }
}