#https://leetcode.com/problems/longest-increasing-subsequence/
#Given an integer array nums, return the length of the longest strictly increasing subsequence.

#A subsequence is a sequence that can be derived from an array
# by deleting some or no elements without changing the order of the remaining elements.
# For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].


from typing import List

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0

        num_count = len(nums)
        dp = [1] * num_count

        for i in range(1, num_count):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
        # 현재 위치에서 자기 자신 보다 작은게 몇개 있나?
        return max(dp)

import unittest

class TestSolution(unittest.TestCase):

    def test_lengthOfLIS(self):
        print(self)

        input_array = [10,9,2,5,3,7,101,18]
        expected = 4

        solution = Solution()
        result = solution.lengthOfLIS(input_array)
        self.assertEqual(result, expected, "The result 1")

        input_array2 = [0,1,0,3,2,3]
        expected2 = 4

        solution = Solution()
        result2 = solution.lengthOfLIS(input_array2)
        self.assertEqual(result2, expected2, "The result 2")

        input_array3 = [7,7,7,7,7,7,7]
        expected3 = 1

        solution = Solution()
        result3 = solution.lengthOfLIS(input_array3)
        self.assertEqual(result3, expected3, "The result 3")


if __name__ == '__main__':
    unittest.main()

