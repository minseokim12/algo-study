class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;

        int N = prices.length;
        int[][] dp = new int[k + 1][N];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int l = 0; l < j; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][l] + prices[j] - prices[l]);
                }
            }
        }
        return dp[k][N - 1];
    }
}
