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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int level = 0;
        int size;
        que.add(root);
        while (!que.isEmpty()) {
            size = que.size();
            // System.out.println(size);
            if (level % 2 == 0) {
                TreeNode temp1 = que.poll();
                for (int i = 0; i < size-1; i++) {
                    TreeNode temp2=que.poll();
                    if (temp1.val%2==0 || temp1.val >= temp2.val) {
                        return false;
                    }
                    if (temp1.left != null) {
                        que.add(temp1.left);
                    }
                    if (temp1.right != null) {
                        que.add(temp1.right);
                    }
                    temp1 = temp2;
                }
                if(temp1.val%2==0){
                    return false;
                }
                if (temp1.left != null) {
                    que.add(temp1.left);
                }
                if (temp1.right != null) {
                    que.add(temp1.right);
                }
            }
             else {
                TreeNode temp1 = que.poll();
                for (int i = 0; i < size-1; i++) {
                    TreeNode temp2 = que.poll();
                    if (temp1.val%2!=0 || temp1.val <= temp2.val) {
                        return false;
                    }
                    if (temp1.left != null) {
                        que.add(temp1.left);
                    }
                    if (temp1.right != null) {
                        que.add(temp1.right);
                    }
                    temp1 = temp2;
                }
                if(temp1.val%2!=0){
                    return false;
                }
                if (temp1.left != null) {
                    que.add(temp1.left);
                }
                if (temp1.right != null) {
                    que.add(temp1.right);
                }
            }
            level=level==0?1:0;
        }
        return true;
    }
}