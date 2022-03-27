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

// 모든 노드를 마지막까지 다 확인해봐야 maxSum 을 알 수 있음 -> 최소 n 번은 봐야하므로 O(n) time complexity
// maxSum 을 cacheing 하므로 O(1) space complexity
// Runtime: 1 ms, faster than 83.12% of Java online submissions for Binary Tree Maximum Path Sum.
// Memory Usage: 47.7 MB, less than 60.78% of Java online submissions for Binary Tree Maximum Path Sum.

class Solution {
    int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        travelSum(root);
        return maxSum;
    }
    
    public int travelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 현재 노드가 root 이고 양쪽으로 분기될 때 maxSum 일 케이스 고려
        int leftSonNodeSum = travelSum(root.left);
        int rightSonNodeSum = travelSum(root.right);
        maxSum = Math.max(maxSum, root.val + leftSonNodeSum + rightSonNodeSum);
        
        // 상위 노드가 root 일 때는 한 쪽으로만 분기
        int currentMaxSum = root.val;
        if (0 < Math.max(leftSonNodeSum, rightSonNodeSum)) {
            currentMaxSum += Math.max(leftSonNodeSum, rightSonNodeSum);
        }
        maxSum = Math.max(maxSum, currentMaxSum);
        return currentMaxSum;
    }
}
