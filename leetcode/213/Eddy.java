import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int ans = dp[0] = nums[0];
        for (int i = 1; i < N - 1; i++) {
            dp[i] = nums[i];
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
            }
            ans = Math.max(ans, dp[i]);
        }

        Arrays.fill(dp, 0);
        for (int i = 1; i < N; i++) {
            dp[i] = nums[i];
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
