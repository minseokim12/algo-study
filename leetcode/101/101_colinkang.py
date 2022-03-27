# https://leetcode.com/problems/symmetric-tree/
# Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
#Input: root = [1,2,2,3,4,4,3]
#Output: true
#Input: root = [1,2,2,null,3,null,3]
#Output: false

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
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        print(root)
        if root is None:
            return True
        else:
            return isMirror(root.left, root.right)

def isMirror(left, right):
    if left is None and right is None:
        return True
    if left is None or right is None:
        return False

    if left.val == right.val:
        outer = isMirror(left.left, right.right)
        inner = isMirror(left.right, right.left)
        return outer and inner
    else:
        return False




import unittest

class TestSum(unittest.TestCase):

    def test_isSymmetric(self):
        print(self)
        list = [1, 2, 2, 3, 4, 4, 3]
        result = Solution.isSymmetric(self, createTreeNode(list, 0))
        self.assertEqual(result, True, "The result 1")
        # TreeNode((1)->L:TreeNode((2)->L:TreeNode((3)->L:None R:None) R:TreeNode((4)->L:None R:None)) R:TreeNode((2)->L:TreeNode((4)->L:None R:None) R:TreeNode((3)->L:None R:None)))

        list2 = [1, 2, 2, None, 3, None, 3]
        result2 = Solution.isSymmetric(self, createTreeNode(list2, 0))
        self.assertEqual(result2, False, "The result 2")
        # TreeNode((1)->L:TreeNode((2)->L:None R:TreeNode((3)->L:None R:None)) R:TreeNode((2)->L:None R:TreeNode((3)->L:None R:None)))

if __name__ == '__main__':
    unittest.main()