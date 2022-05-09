#https://leetcode.com/problems/minimum-path-sum/
#Given a m x n grid filled with non-negative numbers,
# find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

#Note: You can only move either down or right at any point in time.

from typing import List
import collections
import copy

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        origin_grid = []
        if len(grid) <= 0 or grid is None:
            return 0
        row_size = len(grid)
        col_size = len(grid[0])

        for ri in range(row_size):
            for ci in range(col_size):
                if ri == 0 and ci == 0:
                    continue
                if ri - 1 < 0:
                    grid[ri][ci] = grid[ri][ci] + grid[ri][ci-1]
                elif ci - 1 < 0:
                    grid[ri][ci] = grid[ri][ci] + grid[ri-1][ci]
                else:
                    grid[ri][ci] = grid[ri][ci] + min(grid[ri-1][ci], grid[ri][ci-1])

        return grid[-1][-1]


import unittest

class TestSum(unittest.TestCase):

    def test_minPathSum(self):
        print(self)
        input_value = [[1,3,1],[1,5,1],[4,2,1]]
        expected_result = 7
        solution = Solution()
        result = solution.minPathSum(input_value)
        self.assertEqual(result, expected_result, "The result is incorrect")

        input_value2 = [[1,2,3],[4,5,6]]
        expected_result2 = 12
        solution = Solution()
        result2 = solution.minPathSum(input_value2)
        self.assertEqual(result2, expected_result2, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()

