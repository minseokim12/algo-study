package longestcommon;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for (int i = 1; i < strs.length ; i ++) {
            checkCommonPrefix(strs[i]);
        }
        return result;
    }

    public void checkCommonPrefix(String str) {
        int length = Math.min(result.length(), str.length());
        result = result.substring(0, length);

        for (int j = 0; j < length ; j ++) {
            if (result.charAt(j) != str.charAt(j)) {
                result = result.substring(0, j);
                break;
            }
        }
    }

}