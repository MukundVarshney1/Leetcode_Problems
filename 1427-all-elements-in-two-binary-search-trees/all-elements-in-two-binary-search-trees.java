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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        // Inorder always gives sorted list in bst
        Inorder(root1,a);
        Inorder(root2,b);
        // merging two sorted list makes o(n+m) time complexity
        return merge(a,b);
    }
    public void Inorder(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        Inorder(root.left,ans);
        ans.add(root.val);
        Inorder(root.right,ans);
    }
    public List<Integer> merge(List<Integer> a,List<Integer> b){
        int q=0;
        int w=0;
        List<Integer> ans=new ArrayList<>();
        while(q<a.size() && w<b.size()){
            if(a.get(q)<b.get(w)){
                ans.add(a.get(q++));
            }
            else{
                ans.add(b.get(w++));
            }
        }
        while(q<a.size()){
            ans.add(a.get(q++));
        }
        while(w<b.size()){
            ans.add(b.get(w++));
        }
        return ans;
    }
}