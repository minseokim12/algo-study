package longestcommon;

/**
 * https://leetcode.com/problems/word-break/
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; result[i] && j <= s.length(); j++){
                if (wordDict.contains(s.substring(i, j))) {
                    result[j] = true;
                }
            }
        }
        return result[s.length()];
    }

}