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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ll=new ArrayList<>();
        helper(root,ll,"");
        return ll;
    }
    public void helper(TreeNode root,List<String> ll,String s){
        if(root==null){
            return;
        }
        if(s.length()!=0){
            s+="->";
        }
        if(root.left==null && root.right==null){
            ll.add(s+root.val);
            return;
        }
        helper(root.left,ll,s+root.val);
        helper(root.right,ll,s+root.val);
    }
}