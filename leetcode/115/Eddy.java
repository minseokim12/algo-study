class Solution {
    public int numDistinct(String s, String t) {
        char[] S = new char[s.length() + 1];
        char[] T = new char[t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            S[i] = s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            T[i] = t.charAt(i);
        }
        S[S.length - 1] = '$';
        T[T.length - 1] = '$';

        int N = S.length;
        int M = T.length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (S[i] == T[0]) {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < T.length; j++) {
            int count = 0;
            for (int i = 0; i < S.length; i++) {
                if (S[i] == T[j]) {
                    dp[i][j] += count;
                }
                if (S[i] == T[j - 1]) {
                    count += dp[i][j - 1];
                }
            }
        }
        
        return dp[N - 1][M - 1];
    }
}
