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
// 한 층씩 내려가면서 자기 왼쪽 자식과 오른쪽 자식이 symmetric 인지 보면 됨
// 한 바퀴 다 돌아야 하므로 최소 n 번은 봐야 함 . O(n) time complexity

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
// Memory Usage: 42.5 MB, less than 30.72% of Java online submissions for Symmetric Tree.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
   }
    public boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 != null) {
            return false;
        }
        if (n1 != null && n2 == null) {
            return false;
        }
        if (n1 != null && n2 != null && n1.val != n2.val) {
            return false;
        }
        if (n1 == null && n2 == null) {
            return true;
        }
        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
}
