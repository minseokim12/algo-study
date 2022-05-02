#https://leetcode.com/problems/valid-parentheses/
#Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

#An input string is valid if:

#Open brackets must be closed by the same type of brackets.
#Open brackets must be closed in the correct order



class Solution:
    def isValid(self, s: str) -> bool:
        opened = ['[', '(', '{']
        closed = [']', ')', '}']
        stack = []
        for c in s:
            if c in opened:
                stack.append(c)
            else:
                if len(stack) != 0 and stack[-1] == opened[closed.index(c)]:
                    stack.pop()
                else:
                    return False
        return len(stack) == 0

import unittest

class TestSum(unittest.TestCase):

    def test_isValid_Parenthesis(self):
        print(self)
        input_value = "()"
        # target_array = [4, -1, 2, 1]
        expected_result = True
        solution = Solution()
        result = solution.isValid(input_value)
        self.assertEqual(result, expected_result, "The result is incorrect")

        input_value2 = "()[]{}"
        expected_result2 = True
        solution = Solution()
        result2 = solution.isValid(input_value2)
        self.assertEqual(result2, expected_result2, "The result is incorrect")

        input_value3 = "((()))(]"
        # target_array = [1]
        expected_result3 = False
        solution = Solution()
        result3 = solution.isValid(input_value3)
        self.assertEqual(result3, expected_result3, "The result is incorrect")

if __name__ == '__main__':
    unittest.main()

