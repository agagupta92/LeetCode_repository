/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
          ListNode slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();
 
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
 
        while (head != null) {
 
            int i = stack.pop();
            if (head.val == i) {
                ispalin = true;
            }
            else {
                ispalin = false;
                break;
            }
            head = head.next;
        }
        return ispalin;
    }
}