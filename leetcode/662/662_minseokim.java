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

//         1
//    2         3
//  4   5     6   7
// 8.9.10.11 12 13 14 15
// ..
// 아래층으로 내려갈때마다, left son 은 지금 node 에서 *2th node, right son 은 *2+1th node 이다
// 이진 트리이기 때문.
// 그럼 각 층에서 가장 오른쪽에 있는 node 순서에서 가장 왼쪽에 있는 node 순서를 빼면 width 값 산출가능.

// 모든 노드를 한 번씩만 방문하고 val 값을 할당해주면 되므로 O(n) time complexity
// val 값은 floor 마다 cacheing 하므로 O(log(n)) space complexity

// Runtime: 2 ms, faster than 78.87% of Java online submissions for Maximum Width of Binary Tree.
// Memory Usage: 41.9 MB, less than 86.77% of Java online submissions for Maximum Width of Binary Tree.

class Solution {
    Map<Integer, Long> minPointMap = new HashMap<>();
    Map<Integer, Long> maxPointMap = new HashMap<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travel(root, 1, 1);
        long maxWidth = 1;
        for (int floor : minPointMap.keySet()) {
            long currentWidth = maxPointMap.get(floor) - minPointMap.get(floor) + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }
        
        return (int) maxWidth;
    }
    
    public void travel(TreeNode root, int floor, long val) {
        if (root.left != null) {
            putValToMap(floor + 1, val*2);
            travel(root.left, floor + 1, val*2);
        }
        if (root.right != null) {
            putValToMap(floor + 1, val*2 + 1);
            travel(root.right, floor + 1, val*2 + 1);
        }
    }
    
    public void putValToMap(int floor, long val) {
        if (minPointMap.containsKey(floor)) {
            minPointMap.put(floor, Math.min(minPointMap.get(floor), val));
            maxPointMap.put(floor, Math.max(maxPointMap.get(floor), val));
        } else {
            minPointMap.put(floor, val);
            maxPointMap.put(floor, val);
        }
    }
}
