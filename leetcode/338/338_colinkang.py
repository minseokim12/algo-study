# https://leetcode.com/problems/counting-bits/
#Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i]
#is the number of 1's in the binary representation of i.
#Input: n = 2
#Output: [0,1,1]
#Explanation:
#0 --> 0
#1 --> 1
#2 --> 10
#Input: n = 5
#Output: [0,1,1,2,1,2]
#Explanation:
#0 --> 0
#1 --> 1
#2 --> 10
#3 --> 11
#4 --> 100
#5 --> 101

from typing import List

class Solution:
    def countBits(self, n: int) -> List[int]:
        onebit_count_list = [0]
        for i in range(1, n + 1):
            if i % 2 == 1:
                onebit_count_list.append(onebit_count_list[i - 1] + 1)
            else:
                onebit_count_list.append(onebit_count_list[i // 2])
        return onebit_count_list
# 0 : 0000
# 1 : 0001
# 2 : 0010
# 3 : 0011
# 4 : 0100
# 5 : 0101
# 6 : 0110
# 7 : 0111
# 8 : 1000

# 13
#   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
#   0, 1, 1, 2, 1, 2, 2, 3, 1, 2,  2,  3,  2,  3



import unittest

class TestSolution(unittest.TestCase):

    def test_countBits(self):
        print(self)

        input_n = 2
        output_list = [0, 1, 1]

        solution = Solution()
        result = solution.countBits(input_n)
        self.assertEqual(output_list, result, "The result 1")

        input_n2 = 13
        output_list2 = [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3]

        solution = Solution()
        result2 = solution.countBits(input_n2)
        self.assertEqual(output_list2, result2, "The result 2")



if __name__ == '__main__':
    unittest.main()
