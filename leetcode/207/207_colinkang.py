#https://leetcode.com/problems/course-schedule/
#There are a total of numCourses courses you have to take, labeled
#from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi]
#indicates that you must take course bi first if you want to take course ai.
# Input: numCourses = 2, prerequisites = [[1,0]]
# Output: true
# Explanation: There are a total of 2 courses to take.
# To take course 1 you should have finished course 0. So it is possible.
# Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
# Output: false
# Explanation: There are a total of 2 courses to take.
# To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

from typing import List
import collections

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not numCourses:
            return False
        elif not prerequisites:
            return True
        else:
            require = collections.defaultdict(list) # to save prerequisites
            for pair in prerequisites:
                require[pair[0]].append(pair[1])
            path = []
            for i in range(numCourses):
                if not self.DFS(i, require, path):
                    return False
            return True

    def DFS(self, i, require, path):
        # do DFS for i
        if i in path: return False # cycle
        for j in require[i]:
            if not self.DFS(j, require, path + [i]):
                return False
        return True

import unittest

class TestSum(unittest.TestCase):

    def test_canFinish(self):
        print(self)
        list = [[1, 0]]
        numCourses = 2
        solution = Solution()
        result = solution.canFinish(numCourses, list)
        self.assertEqual(result, True, "The result 1")

        list2 = [[ 1, 0], [0, 1]]
        numCourses2 = 2
        solution2 = Solution()
        result2 = solution2.canFinish(numCourses2, list2)
        self.assertEqual(result2, False, "The result 2")

if __name__ == '__main__':
    unittest.main()