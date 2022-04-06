class Solution {
    public String longestPalindrome(String s) {
        char[] S = s.toCharArray();
        int N = S.length;
        boolean[][] PALINDROME_IMPOSSIBLE = new boolean[N][N];

        int ans_start = 0;
        int ans_length = 1;
        for (int len = 1; len < N; len++) {
            for (int start = 0; start + len < N; start++) {
                if (S[start] == S[start + len] && !PALINDROME_IMPOSSIBLE[start + 1][start + len - 1]) {
                    ans_start = start;
                    ans_length = len + 1;
                } else {
                    PALINDROME_IMPOSSIBLE[start][start + len] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = ans_start; i - ans_start + 1 <= ans_length; i++) {
            sb.append(S[i]);
        }
        return sb.toString();
    }
}
