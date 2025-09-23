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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        int size=que.size();
        int a=Integer.MIN_VALUE;
        while(!que.isEmpty()){
            size--;
            TreeNode x=que.poll();
            if(x.left!=null){
                que.add(x.left);
            }
            if(x.right!=null){
                que.add(x.right);
            }
            a=Math.max(a,x.val);
            if(size==0){
                size=que.size();
                ans.add(a);
                a=Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}