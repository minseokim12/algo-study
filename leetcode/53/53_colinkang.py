# https://leetcode.com/problems/maximum-subarray/
# Given an integer array nums,
# find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
#A subarray is a contiguous part of an array.

from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        continuous_maxsum = [0]*len(nums)
        continuous_maxsum[0] = nums[0]
        for i in range(1, len(nums)):
            continuous_maxsum[i] = max(continuous_maxsum[i-1]+nums[i], nums[i])
        return max(continuous_maxsum)


import unittest

class TestSum(unittest.TestCase):

    def test_maxSubArray(self):
        print(self)
        input_array = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        # target_array = [4, -1, 2, 1]
        expected_result = 6
        solution = Solution()
        result = solution.maxSubArray(input_array)
        self.assertEqual(result, expected_result, "The result is incorrect")

        input_array2 = [1]
        # target_array = [1]
        expected_result2 = 1
        solution = Solution()
        result2 = solution.maxSubArray(input_array2)
        self.assertEqual(result2, expected_result2, "The result is incorrect")

        input_array3 = [5, 4, -1, 7, 8]
        # target_array = [1]
        expected_result3 = 23
        solution = Solution()
        result3 = solution.maxSubArray(input_array3)
        self.assertEqual(result3, expected_result3, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()
