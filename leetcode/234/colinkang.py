#https://leetcode.com/problems/palindrome-linked-list/
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        words = []
        current = head
        while (current is not None):
            words.append(current.val)
            current = current.next
        #return vals == vals[::-1]
        wordsreverse = words[:]
        wordsreverse.reverse()
        return words == wordsreverse