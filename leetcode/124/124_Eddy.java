class Solution {

    int ans = -987654321;

    private int find_one_side_PathSum(TreeNode node) {
        if (node == null) return 0;

        int left_side_path_sum = Math.max(find_one_side_PathSum(node.left), 0);
        int right_side_path_sum = Math.max(find_one_side_PathSum(node.right), 0);

        ans = Math.max(ans, left_side_path_sum + node.val + right_side_path_sum);

        return node.val + Math.max(left_side_path_sum, right_side_path_sum);
    }

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;

        find_one_side_PathSum(root);
        return ans;
    }
}
