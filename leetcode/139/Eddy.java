import java.util.List;

class Solution {

    private static class Trie {
        private Trie[] child;
        private boolean isEnded;

        Trie() {
            this.child = new Trie[26];
        }

        void insert(char[] input, int idx) {
            if (input.length == idx) {
                isEnded = true;
                return;
            }

            if (child[input[idx] - 'a'] == null) {
                child[input[idx] - 'a'] = new Trie();
            }
            child[input[idx] - 'a'].insert(input, ++idx);
        }

        Trie getChild(char input) {
            if (child[input - 'a'] != null) {
                return child[input - 'a'];
            }
            return null;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //Trie 만들기
        Trie root = new Trie();
        for (String word : wordDict) {
            root.insert(reverse(word), 0);
        }

        //DP 초기화
        int S = s.length();
        boolean[] dp = new boolean[S + 1];
        dp[0] = true;

        //DP 만들기
        Trie cur;
        for (int i = 0; i < S; i++) {
            cur = root;
            for (int j = i; j >= 0; j--) {
                if ((cur = cur.getChild(s.charAt(j))) == null) {
                    break;
                }
                if (cur.isEnded && dp[j]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[S];
    }

    private char[] reverse(String s) {
        char[] ret = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ret[i] = s.charAt(s.length() - 1 - i);
        }
        return ret;
    }
}
