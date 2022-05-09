/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
class Solution {

    private String result = "";

    public String longestWord(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            root.insert(word);
        }

        dfs(root, "");

        return result;
    }

    private void dfs(Trie t, String s) {
        if (s.length() > result.length()) {
            result = s;
        }
        for (int i = 0; i < 26 ; i ++) {
            if (t.children[i] != null) {
                Trie child = t.children[i];
                if (child.isEnd) {
                    dfs(child, s + (char)(i + 'a'));
                }
            }
        }
    }

    class Trie {
        private Trie[] children = new Trie[26];
        private boolean isEnd = false;

        public void insert(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new Trie();
                }
                t = t.children[c - 'a'];
            }
            t.isEnd = true;
        }
    }

}