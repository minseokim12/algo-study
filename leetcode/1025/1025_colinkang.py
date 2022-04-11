# https://leetcode.com/problems/divisor-game/
#Alice and Bob take turns playing a game, with Alice starting first.
#Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
#Choosing any x with 0 < x < n and n % x == 0.
#    Replacing the number n on the chalkboard with n - x.
#    Also, if a player cannot make a move, they lose the game.
#
#Return true if and only if Alice wins the game, assuming both players play optimally.



class Solution:
    def divisorGame(self, n: int) -> bool:
        dp=[False]*(n+1)
        dp[0],dp[1]=False,False
        for i in range(2,n+1):
            for j in range(1,i):
                if i%j==0 and dp[i-j]==False:
                    dp[i]=True
                    break
        return dp[-1]


def gcd(a, b) -> int:
    if b == 0:
        return a
    return gcd(b, b % a)


import unittest

class TestSolution(unittest.TestCase):

    def test_divisorGame(self):
        print(self)

        input_num = 2
        expected = True
        solution = Solution()
        result = solution.divisorGame(input_num)
        self.assertEqual(expected, result, "The result 1")

        input_num2 = 3
        expected2 = False
        solution = Solution()
        result2 = solution.divisorGame(input_num2)
        self.assertEqual(expected2, result2, "The result 2")

        input_num3 = 10
        expected3 = True
        solution = Solution()
        result3 = solution.divisorGame(input_num3)
        self.assertEqual(expected3, result3, "The result 3")

        input_num4 = 11
        expected4 = False
        solution = Solution()
        result4 = solution.divisorGame(input_num4)
        self.assertEqual(expected4, result4, "The result 4")


if __name__ == '__main__':
    unittest.main()