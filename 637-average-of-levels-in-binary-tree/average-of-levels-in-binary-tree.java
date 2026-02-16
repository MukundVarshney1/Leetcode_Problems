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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        double sum=0;
        int c=0;
        int size=1;
        while(!q.isEmpty()){
            if(size==0){
                size=q.size();
                res.add(sum/c);
                sum=0;
                c=0;
            }
            TreeNode r=q.poll();
            sum+=r.val;
            c++;
            if(r.left!=null){
                q.add(r.left);
            }
            if(r.right!=null){
                q.add(r.right);
            }
            size--;
        }
        res.add(sum/c);
        return res;
    }
}