class Solution {
    public int splitArray(int[] nums, int m) {
        int N = nums.length;
        int[][] dp = new int[m + 1][N];

        dp[1][0] = nums[0];
        for (int i = 1; i < N; i++) {
            dp[1][i] = dp[1][i - 1] + nums[i];
        }

        for (int i = 2; i <= m; i++) {
            for (int j = i - 1; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i - 2; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], dp[1][j] - dp[1][k]));
                }
            }
        }
        return dp[m][N - 1];
    }
}
