import java.util.HashSet;
import java.util.Set;

class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    private boolean dfs(TreeNode node, Set<Integer> set, int K) {
        if (node == null) return false;

        if (set.contains(K - node.val)) return true;

        set.add(node.val);
        return dfs(node.left, set, K) || dfs(node.right, set, K);
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, new HashSet<Integer>(), k);
    }
}
