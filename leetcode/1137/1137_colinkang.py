# https://leetcode.com/problems/n-th-tribonacci-number/
#The Tribonacci sequence Tn is defined as follows:
#T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
#Given n, return the value of Tn.

class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        t0 = 0
        t1 = 1
        t2 = 1
        for i in range(n-2):
            tn = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = tn
        return t2


import unittest

class TestSum(unittest.TestCase):

    def test_tribonacci(self):
        print(self)
        input_value = 4
        expected_result = 4
        solution = Solution()
        result = solution.tribonacci(input_value)
        self.assertEqual(result, expected_result, "The result is incorrect")

        input_value2 = 25
        expected_result2 = 1389537
        solution = Solution()
        result2 = solution.tribonacci(input_value2)
        self.assertEqual(result2, expected_result2, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()

