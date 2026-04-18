class Solution {
    
    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        return isSameTree(a.left, b.left) &&
               isSameTree(a.right, b.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }
}