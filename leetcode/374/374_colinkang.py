#https://leetcode.com/problems/guess-number-higher-or-lower/
#Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

#You call a pre-defined API int guess(int num), which returns three possible results:

#-1: Your guess is higher than the number I picked (i.e. num > pick).
#1: Your guess is lower than the number I picked (i.e. num < pick).
#0: your guess is equal to the number I picked (i.e. num == pick).



class Solution:

    def setPicked(self, n: int):
       self.picked = n

    def getPicked(self) -> int:
        return self.picked

    def guessNumber(self, n: int) -> int:
        pick_range = [1, n]
        while True:
            pick = sum(pick_range) // 2
            result = self.guess(pick)
            if result > 0:
                pick_range[0] = pick + 1
            elif result < 0:
                pick_range[1] = pick - 1
            else:
                return pick

    def guess(self, num: int) -> int:
        if self.getPicked() > num:
            return 1
        elif self.getPicked() < num:
            return -1
        elif self.getPicked() == num:
            return 0



import unittest

class TestSolution(unittest.TestCase):

    def test_guessNumber(self):
        print(self)

        input_n = 10
        input_picked = 6

        solution = Solution()
        solution.setPicked(input_picked)
        result = solution.guessNumber(input_n)
        self.assertEqual(input_picked, result, "The result 1")

        input_n = 100
        input_picked = 55

        solution = Solution()
        solution.setPicked(input_picked)
        result = solution.guessNumber(input_n)
        self.assertEqual(input_picked, result, "The result 1")



if __name__ == '__main__':
    unittest.main()
