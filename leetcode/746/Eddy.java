class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[N];
    }
}
