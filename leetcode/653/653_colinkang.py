# https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
#Given the root of a Binary Search Tree and a target number k,
#return true if there exist two elements in the BST such that their sum is equal to the given target
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

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        print(root)
        queue = [root]
        number_set = set()
        while queue:
            current = queue.pop()
            remain_num = k - current.val
            if remain_num in number_set:
                return True
            number_set.add(current.val)
            if current.left:
                queue.append(current.left)
            if current.right:
                queue.append(current.right)
        return False



import unittest

class TestSum(unittest.TestCase):

    def test_findTarget(self):
        print(self)
        input_list = [5, 3, 6, 2, 4, None, 7]
        target_value = 7
        expected_result = True
        solution = Solution()
        result = solution.findTarget(createTreeNode(input_list, 0), target_value)
        self.assertEqual(result, expected_result, "The result is incorrect")

        input_list2 = [13, 3, 6, 2, 4, None, 15]
        target_value2 = 28
        expected_result2 = True
        result2 = solution.findTarget(createTreeNode(input_list2, 0), target_value2)
        self.assertEqual(result2, expected_result2, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()
