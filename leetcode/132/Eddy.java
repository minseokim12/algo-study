class Solution {
    public int minCut(String s) {
        char[] S = s.toCharArray();
        int N = S.length;

        int[] dp = new int[N + 1];
        boolean[][] palindrome_impossible = new boolean[N][N];

        for (int j = 0; j < N; j++) {
            dp[j + 1] = dp[j] + 1;
            for (int i = j - 1; i >= 0; i--) {
                if (S[i] == S[j] && !palindrome_impossible[i + 1][j - 1]) {
                    dp[j + 1] = Math.min(dp[i] + 1, dp[j + 1]);
                } else {
                    palindrome_impossible[i][j] = true;
                }
            }
        }
        
        return dp[N] - 1;
    }
}
