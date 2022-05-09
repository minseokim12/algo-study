#https://leetcode.com/problems/maximum-repeating-substring/

#For a string sequence, a string word is k-repeating
# if word concatenated k times is a substring of sequence.
# The word's maximum k-repeating value is the highest value k where word
# is k-repeating in sequence. If word is not a substring of sequence,
# word's maximum k-repeating value is 0.

#Given strings sequence and word, return the maximum k-repeating value of word in sequence.

class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
            count = 0
            word_unit = word
            compare_word = word
            while(compare_word in sequence):
                count += 1
                compare_word += word_unit
            return count

import unittest

class TestSolution(unittest.TestCase):

    def test_maxRepeating(self):
        print(self)

        input_sequence = 'ababc'
        input_word = 'ab'
        expected = 2

        solution = Solution()
        result = solution.maxRepeating(input_sequence, input_word)
        self.assertEqual(result, expected, "The result 1")


        input_sequence2 = 'ababc'
        input_word2 = 'ba'
        expected2 = 1

        solution = Solution()
        result2 = solution.maxRepeating(input_sequence2, input_word2)
        self.assertEqual(result2, expected2, "The result 2")


        input_sequence3 = 'abcab'
        input_word3 = 'ab'
        expected3 = 1

        solution = Solution()
        result3 = solution.maxRepeating(input_sequence3, input_word3)
        self.assertEqual(result3, expected3, "The result 3")

if __name__ == '__main__':
    unittest.main()
