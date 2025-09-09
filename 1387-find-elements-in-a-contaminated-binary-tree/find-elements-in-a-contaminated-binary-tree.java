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
class FindElements {
    TreeSet<Integer> ans;
    public FindElements(TreeNode root) {
        root.val=0;
        ans=new TreeSet<>();
        helper(root);
    }
    public TreeNode helper(TreeNode root){
        ans.add(root.val);
        if(root.left!=null){
            root.left.val=root.val*2+1;
            helper(root.left);
        }
        if(root.right!=null){
            root.right.val=root.val*2+2;
            helper(root.right);
        }
        return root;
    }
    
    public boolean find(int target) {
        return ans.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */