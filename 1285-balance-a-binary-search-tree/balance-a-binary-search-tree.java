class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> vals = new ArrayList<>();
        inorder(root, vals);
        return build(0, vals.size() - 1, vals);
    }

    private void inorder(TreeNode root, List<TreeNode> vals) {
        if (root == null) return;
        inorder(root.left, vals);
        root.left=null;
        vals.add(root);
        inorder(root.right, vals);
        root.right=null;
    }

    private TreeNode build(int l, int r, List<TreeNode> vals) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        TreeNode root =vals.get(mid);

        root.left = build(l, mid - 1, vals);
        root.right = build(mid + 1, r, vals);

        return root;
    }
}
