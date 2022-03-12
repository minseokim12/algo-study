# 204
# https://leetcode.com/problems/count-primes/
# Given an integer n, return the number of prime numbers that are strictly less than n.
#Input: n = 10
#Output: 4
#Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

class Solution:
    def countPrimes(self, n: int) -> int:
        nonPrimeMarker = [0] * n
        countPrimes = 0
        for currentNumber in range(2, n):
            if nonPrimeMarker[currentNumber]: continue
            countPrimes += 1
            # square
            markStart = currentNumber**2
            lastBefore = (n - 1)
            # // a divide b then ceil
            round = lastBefore // currentNumber
            roundAdjust = round - currentNumber + 1
            nonPrimeMark = [1] * roundAdjust
            nonPrimeMarker[markStart:n:currentNumber] = nonPrimeMark
        return countPrimes

import unittest

class TestSum(unittest.TestCase):

    def test_countPrimes(self):
        print(self)
        #result = Solution.countPrimes(self, 10)
        #self.assertEqual(result, 4, "The result is incorrect")
        result = Solution.countPrimes(self, 100)
        # 100 > 25
        # 499979 > 41537
        # 200 > 46
        self.assertEqual(result, 25, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()