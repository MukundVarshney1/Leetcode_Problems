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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> q) {
        List<Integer> ll=new ArrayList<>();
        inorder(root,ll);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<q.size();i++){
            List<Integer> a=new ArrayList<>();
            a.add(min(q.get(i),ll));
            a.add(max(q.get(i),ll));
            ans.add(a);
        }
        return ans;
    }
    public void inorder(TreeNode root,List<Integer> ll){
        if(root==null){
            return;
        }
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
    public int min(int tgt,List<Integer> ll){
        int lo=0;
        int hi=ll.size()-1;
        int ans=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(ll.get(mid)<=tgt){
                ans=ll.get(mid);
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
    public int max(int tgt,List<Integer> ll){
        int lo=0;
        int hi=ll.size()-1;
        int ans=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(ll.get(mid)>=tgt){
                ans=ll.get(mid);
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}