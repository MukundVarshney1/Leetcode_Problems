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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans=new ArrayList<>();
        helper(root,to_delete,ans);
        if(!search(root.val,to_delete)){
            ans.add(root);
        }
        return ans;
    }
    public TreeNode helper(TreeNode root,int[] del,List<TreeNode> ans){
        if(root==null){
            return null;
        }
        TreeNode a=helper(root.left,del,ans);
        TreeNode b=helper(root.right,del,ans);
        root.left=a;
        root.right=b;
        if(search(root.val,del)){
            if(a!=null){
                ans.add(a);
            }
            if(b!=null){
                ans.add(b);
            }
            return null;
        }
        return root;
    }
    public boolean search(int val,int[] del){
        for(int i=0;i<del.length;i++){
            if(val==del[i]){
                return true;
            }
        }
        return false;
    }
}