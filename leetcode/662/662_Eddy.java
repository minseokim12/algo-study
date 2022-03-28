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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    private static class TreeNodeWithLevel {
        TreeNode node;
        long idx;
        
        public TreeNodeWithLevel(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        long answer = 1;
        
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(root, 0));
        
        TreeNodeWithLevel cur;
        while (!queue.isEmpty()) {
            Queue<TreeNodeWithLevel> new_queue = new LinkedList<>();
            
            long from = queue.peek().idx;            
            long minus = -1;            
            while (!queue.isEmpty()) {
                cur = queue.poll();
                
                if (cur.node.left != null) {
                    if (minus == -1) {
                        minus = cur.idx * 2;
                    }
                    new_queue.add(new TreeNodeWithLevel(cur.node.left, cur.idx * 2 - minus));
                }
                if (cur.node.right != null) {
                    if (minus == -1) {
                        minus = cur.idx * 2 + 1;
                    }
                    new_queue.add(new TreeNodeWithLevel(cur.node.right, cur.idx * 2 + 1 - minus));
                }
                
                if (queue.isEmpty()) {
                    answer = Math.max(answer, cur.idx - from + 1);
                }
            }
            
            queue = new_queue;
        }
        
        return (int) answer;
    }
}
