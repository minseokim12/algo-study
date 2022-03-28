class Solution {
    int ans = 0;
    private int dfs(TreeNode cur) {
        if (cur == null) return 0;
        
        int dfs_left = dfs(cur.left);
        int dfs_right = dfs(cur.right);

        if (dfs_left == -1 || dfs_right == -1) {
            ans++;
            return 1;
        }
        
        if (dfs_left == 1 || dfs_right == 1) {
            return 0;
        }
        
        return -1;        
    }

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == -1) ans++;
        
        return ans;
    }
}
