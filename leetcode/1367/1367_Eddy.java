import java.util.ArrayList;

class Solution {
    int[] W;
    int[] fail;
    private void init(ListNode head) {
        ArrayList<Integer> arrayBuilder = new ArrayList<>();
        while (head != null) {
            arrayBuilder.add(head.val);
            head = head.next;
        }

        W = new int[arrayBuilder.size()];
        for (int i = 0; i < arrayBuilder.size(); i++) {
            W[i] = arrayBuilder.get(i);
        }

        fail = new int[W.length];
        for (int i = 1, j = 0; i < W.length; i++) {
            while (j > 0 && W[i] != W[j]) {
                j = fail[j - 1];
            }
            if (W[i] == W[j]) {
                fail[i] = ++j;
            }
        }
    }

    private boolean KMP(TreeNode node, int idx) {
        if (node == null) return false;

        int val = node.val;
        while (idx > 0 && val != W[idx]) {
            idx = fail[idx - 1];
        }
        if (val == W[idx]) {
            if (W.length == ++idx) {
                return true;
            }
        }
        return KMP(node.left, idx) || KMP(node.right, idx);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        init(head);
        return KMP(root, 0);
    }
}
