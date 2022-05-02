#https://leetcode.com/problems/is-subsequence/
#Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

#A subsequence of a string is a new string that is formed from the original string
# by deleting some (can be none) of the characters
# without disturbing the relative positions of the remaining characters.
# (i.e., "ace" is a subsequence of "abcde" while "aec" is not).




class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i = 0
        for c in t:
            if i == len(s): return True  # If match full s -> then s is a subsequence
            if s[i] == c:
                i += 1
        return i == len(s)

import unittest

class TestSum(unittest.TestCase):

    def test_isSubsequence(self):
        print(self)
        input_s = "abc"
        input_t = "ahbgdc"
        expected_result = True
        solution = Solution()
        result = solution.isSubsequence(input_s, input_t)
        self.assertEqual(result, expected_result, "The result is incorrect")

        input_s2 = "axc"
        input_t2 = "ahbgdc"
        expected_result2 = False
        solution = Solution()
        result2 = solution.isSubsequence(input_s2, input_t2)
        self.assertEqual(result2, expected_result2, "The result is incorrect")

        input_s3 = "aec"
        input_t3 = "abcde"
        expected_result3 = False
        solution = Solution()
        result3 = solution.isSubsequence(input_s3, input_t3)
        self.assertEqual(result3, expected_result3, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()

