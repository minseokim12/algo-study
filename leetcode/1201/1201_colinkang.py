# https://leetcode.com/problems/ugly-number-iii/
# An ugly number is a positive integer that is divisible by a, b, or c.
# Given four integers n, a, b, and c, return the nth ugly number.
#Input: n = 3, a = 2, b = 3, c = 5
#Output: 4
# Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.

import math

class Solution:
    def nthUglyNumber(self, n: int, a: int, b: int, c: int) -> int:
        def enough(num) -> bool:
            total = mid//a + mid//b + mid//c - mid//ab - mid//ac - mid//bc + mid//abc
            return total >= n

        ab = a * b // math.gcd(a, b)
        ac = a * c // math.gcd(a, c)
        bc = b * c // math.gcd(b, c)
        abc = a * bc // math.gcd(a, bc)
        left, right = 1, 10 ** 10
        while left < right:
            mid = left + (right - left) // 2
            if enough(mid):
                right = mid
            else:
                left = mid + 1
        return left

class Solution2:
    def isUgly(self, num:int, a: int, b: int, c: int) -> bool:
        if num is 0: return False
        for i in [a, b, c]:
            while num % i is 0:
                num = num // i
        return num is 1

import unittest

class TestSolution(unittest.TestCase):

    def test_nthUglyNumber(self):
        print(self)

        result = Solution.nthUglyNumber(self, 3, 2, 3, 5)
        self.assertEqual(result, 4, "The result is incorrect")

        result2 = Solution.nthUglyNumber(self, 4, 2, 3, 4)
        self.assertEqual(result2, 6, "The result is incorrect")

        result3 = Solution2.isUgly(self, 10, 2, 3, 4)
        self.assertEqual(result3, False, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()