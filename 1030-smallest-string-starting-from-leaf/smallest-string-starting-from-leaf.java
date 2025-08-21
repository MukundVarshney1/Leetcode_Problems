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
    StringBuilder ans=new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder str=new StringBuilder();
        helper(root,str);
        return ans.toString();
    }
    public void helper(TreeNode root,StringBuilder str){
        if(root==null){
            return;
        }
        str.append((char)('a'+root.val));
        if(root.left==null && root.right==null){
            str.reverse();
            if(ans.length()==0){
                ans=new StringBuilder(str);
                str.reverse();
                str.delete(str.length()-1,str.length());
                return;
            }else{
                StringBuilder m=compare(ans,str);
                ans=new StringBuilder(m);
                str.reverse();
                str.delete(str.length()-1,str.length());
                return;
            }
        }
        helper(root.left,str);
        helper(root.right,str);
        str.delete(str.length()-1,str.length());
        

    }
    public StringBuilder compare(StringBuilder a,StringBuilder b){
        int m=Math.min(a.length(),b.length());
            for(int i=0;i<m;i++){
                if(a.charAt(i)<b.charAt(i)){
                    return a;
                }
                else if(a.charAt(i)>b.charAt(i)){
                    return b;
                }
            }
            if(m==a.length()){
                return a;
            }
            return b;
    }
}