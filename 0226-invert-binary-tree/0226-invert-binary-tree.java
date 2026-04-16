class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recurse
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}