class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int N = dungeon.length;
        int M = dungeon[0].length;

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[N - 1][M] = dp[N][M - 1] = 1;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] <= 0) dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }
}
