#https://leetcode.com/problems/min-cost-climbing-stairs/
#You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
#You can either start from the step with index 0, or the step with index 1.
#Return the minimum cost to reach the top of the floor.
#Input: cost = [10,15,20]
#Output: 15
#Explanation: You will start at index 1.
#- Pay 15 and climb two steps to reach the top.
#The total cost is 15.
#Input: cost = [1,100,1,1,1,100,1,1,100,1]
#Output: 6
#Explanation: You will start at index 0.
#- Pay 1 and climb two steps to reach index 2.
#- Pay 1 and climb two steps to reach index 4.
#- Pay 1 and climb two steps to reach index 6.
#- Pay 1 and climb one step to reach index 7.
#- Pay 1 and climb two steps to reach index 9.
#- Pay 1 and climb one step to reach the top.
#The total cost is 6.

from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        total_stair_cost_map = [0] * (n + 1)  # 0 : not started 1 : first step to cost 2 : second step to cost
        for i in range(2, n + 1):
            onestep_cost = total_stair_cost_map[i - 1] + cost[i - 1]
            twostep_cost = total_stair_cost_map[i - 2] + cost[i - 2]
            total_stair_cost_map[i] = min(onestep_cost, twostep_cost)
        return total_stair_cost_map[n]

#   1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
# 0, 0,  1, 2, 2, 3,   3, 4, 4,   5, 6]


import unittest

class TestSolution(unittest.TestCase):

    def test_minCostClimbingStairs(self):
        print(self)

        list = [10,15,20]
        targetNum = 15
        solution = Solution()
        result = solution.minCostClimbingStairs(list)
        self.assertEqual(targetNum, result, "The result 1")


        list2 = [1, 100, 1, 1, 1, 100, 1, 1, 100,1 ]
        targetNum2 = 6
        solution = Solution()
        result2 = solution.minCostClimbingStairs(list2)
        self.assertEqual(targetNum2, result2, "The result 2")

if __name__ == '__main__':
    unittest.main()