# https://leetcode.com/problems/diameter-of-binary-tree/
# Given the root of a binary tree, return the length of the diameter of the tree.
# The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
#
# The length of a path between two nodes is represented by the number of edges between them.

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
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.max_length = 0


        def depth(node: Optional[TreeNode]) -> int:
            if not node:
                return 0
            depth_left = depth(node.left)
            depth_right = depth(node.right)
            self.max_length = max(self.max_length, depth_left + depth_right)
            return 1 + max(depth_left, depth_right)

        depth(root)

        return self.max_length

import unittest

class TestSum(unittest.TestCase):

    def test_diameterOfBinaryTree(self):
        print(self)
        input_list = [1, 2, 3, 4, 5]
        expected_result = 3
        solution = Solution()
        result = solution.diameterOfBinaryTree(createTreeNode(input_list, 0))
        self.assertEqual(expected_result, result, "The result is incorrect")

        input_list3 = [1, 2]
        expected_result3 = 1
        solution = Solution()
        result3 = solution.diameterOfBinaryTree(createTreeNode(input_list3, 0))
        self.assertEqual(expected_result3, result3, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()
