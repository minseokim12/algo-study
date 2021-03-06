// O(n), O(n)
// Runtime: 45 ms, faster than 6.68% of Java online submissions 
// Memory Usage: 110.4 MB, less than 38.80% of Java online submissions
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>(); 
        ListNode test = head;
        
        while(test != null) {
            stack.push(test.val);
            test = test.next;
        }
        
        while(!stack.isEmpty()) {
            if (!stack.pop().equals(head.val)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}