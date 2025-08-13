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

//  note 1 means camera is set up
// 0 means camera is in range due to any child has
// -1 means need of camera for any of the child or both
class Solution {
    int camera=0;
    public int minCameraCover(TreeNode root) {
        int c=minCamera(root);
        if(c==-1){
            camera++;
        }
        return camera;
    }
    public int minCamera(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=minCamera(root.left);
        int right=minCamera(root.right);
        if(left==-1 || right==-1){
            camera++;
            return 1;//camera setup kra is node pe
        }
        else if(left==1 || right==1){//isme se koi ek ke pass camera hai or dusra covered hai
            return 0;
        }
        else{
            return -1;
        }
    }
}