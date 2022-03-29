class Solution {

    int ans = 0;
    private int one_side_diameter(TreeNode node) {
        if (node == null) return 0;

        int left_side_diameter = one_side_diameter(node.left);
        int right_side_diameter = one_side_diameter(node.right);

        ans = Math.max(ans, left_side_diameter + right_side_diameter);
        return Math.max(left_side_diameter, right_side_diameter) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        one_side_diameter(root);
        return ans;
    }
}
