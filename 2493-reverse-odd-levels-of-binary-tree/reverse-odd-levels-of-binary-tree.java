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
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int h=0;
        int size=0;
        Stack<Integer> st=new Stack<>();
        while(!q.isEmpty()){
            if(size==0 && h%2==1){
                int s=q.size();
                while(s-->0){
                    TreeNode d=q.poll();
                    st.push(d.val);
                    q.add(d);
                }
            }
            if(size==0){
                h++;
                size=q.size();
            }
            TreeNode r=q.poll();
            if(r.left!=null){
                q.add(r.left);
            }
            if(r.right!=null){
                q.add(r.right);
            }
            if(!st.isEmpty()){
                r.val=st.pop();
            }
            size--;
        }
        return root;
    }
}