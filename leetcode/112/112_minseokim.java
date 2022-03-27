

// targetSum 은 leaf 개수만큼 존재할 것
// 층수만큼 내려가야 targetSum 알 수 있어서 시간복잡도는 높이 O(logn) 일 것 같지만 또 그걸 leaf 개수만큼 여러번 계산해야 하므로 결국 한개의 node 도 빼지 않고 다 돌아야 하는 셈.. 그래서 O(n)
// Runtime: 1 ms, faster than 52.68% of Java online submissions for Path Sum.
// Memory Usage: 43.8 MB, less than 43.45% of Java online submissions for Path Sum.

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return found(root, targetSum, 0);
    }
    
    public boolean found(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return targetSum == currentSum;
        }
        if (root.left != null && root.right == null) {
            return found(root.left, targetSum, currentSum + root.val);
        }
        if (root.left == null && root.right != null) {
            return found(root.right, targetSum, currentSum + root.val);
        }
        if (found(root.left, targetSum, currentSum + root.val)) {
            return true;
        }
        if (found(root.right, targetSum, currentSum + root.val)) {
            return true;
        }
        return false;
    }
}
