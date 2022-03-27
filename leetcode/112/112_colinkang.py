# https://leetcode.com/problems/path-sum/
#Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

# A leaf is a node with no children.
# Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
# Output: true
# Explanation: The root-to-leaf path with the target sum is shown.
# Input: root = [1,2,3], targetSum = 5
# Output: false
# Explanation: There two root-to-leaf paths in the tree:
# (1 --> 2): The sum is 3.
# (1 --> 3): The sum is 4.
# There is no root-to-leaf path with sum = 5.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        return "TreeNode((" + str(self.val) + ")->L:" + str(self.left) + " R:" + str(self.right) + ")"

def createTreeNode(list, index):
    pNode = None
    if index < len(list):
        if list[index] == None:
            return
        pNode = TreeNode(list[index])
        leftIndex = 2 * index + 1
        rightIndex = 2 * index + 2
        pNode.left = createTreeNode(list, leftIndex) # [1, 3, 7, 15, ...]
        pNode.right = createTreeNode(list, rightIndex) # [2, 5, 12, 25, ...]
    return pNode


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False

        if root.val == targetSum and not (root.left or root.right):
            return True

        targetSum -= root.val

        return self.hasPathSum(root.left, targetSum) or self.hasPathSum(root.right, targetSum)



import unittest

class TestSum(unittest.TestCase):

    def test_hasPathSum(self):
        print(self)
        list = [5, 4, 8, 11, None, 13, 4, 7, 2, None, None, None, 1]
        targetNum = 22
        solution = Solution()
        result = solution.hasPathSum(createTreeNode(list, 0), targetNum)
        self.assertEqual(result, True, "The result 1")

        list2 = [1, 2, 3]
        targetNum2 = 4
        solution2 = Solution()
        result2 = solution2.hasPathSum(createTreeNode(list2, 0), targetNum2)
        self.assertEqual(result2, True, "The result 2")

if __name__ == '__main__':
    unittest.main()