# 914 https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
#Since we divide the deck of N cards into say,
# K piles of X cards each, we must have N % X == 0.

#Then, say the deck has C_i copies of cards with number i.
# Each group with number i has X copies, so we must have C_i % X == 0.
# These are necessary and sufficient conditions.


from typing import List
from typing import collections
from functools import reduce


class Solution:

    def hasGroupsSizeX(self, deck):
        count = collections.Counter(deck)
        N = len(deck)
        for X in range(2, N+1):
            if N % X == 0:
                if all(v % X == 0 for v in count.values()):
                    return True
        return False

    def hasGroupsSizeX2(self, deck: List[int]) -> bool:
        count = collections.Counter(deck)
        mini = min(count.values())

        if mini < 2:
            return False
        for i in range(mini+1,1,-1):
            res = all(value % i ==0 for value in count.values())
            if res: return True
        return False

    def hasGroupsSizeX3(self, deck):
        def gcd(a, b):
            while b: a, b = b, a % b
            return a
        count = collections.Counter(deck).values()
        return reduce(gcd, count) > 1

import fractions

class Colin:
    def hasGroupsSizeXColin(self, deck: List[int]) -> bool:
        sameSize = True
        deckCounter = [0] * len(deck)
        for key, val in enumerate(deck):
            deckCounter[val] += 1
        formerNumber = deckCounter[0]
        for key, val in enumerate(deckCounter):
            formerNumber = val
            if deckCounter[key] > 0 and formerNumber != deckCounter[key]:
                sameSize = False
        return sameSize



    def hasGroupsSizeX(self, deck):
        from fractions import gcd
        vals = collections.Counter(deck).values()
        return reduce(gcd, vals) >= 2

    def hasGroupsSizeY(self, deck):
        return reduce(fractions.gcd, collections.Counter(deck).values()) > 1

import unittest

class TestSum(unittest.TestCase):

    def test_hasGroupsSizeX(self):
        print(self)
        #result = Solution.countPrimes(self, 10)
        #self.assertEqual(result, 4, "The result is incorrect")
        input = [1,2,3,4,4,3,2,1]
        result = Solution.hasGroupsSizeX(self, input)
        self.assertEqual(result, True, "The result is incorrect")
        input2 = [1,2,3,4,4,3,2,1,1]
        result2 = Solution.hasGroupsSizeX(self, input2)
        self.assertEqual(result2, False, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()