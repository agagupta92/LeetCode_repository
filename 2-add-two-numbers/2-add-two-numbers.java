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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        int carry =0;
         ListNode prev = res;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
                //System.out.println(" sum : " + sum + " carry : " + carry);
            } else {
                carry = 0;
                
            }
            ListNode res1 = new ListNode(sum);
            prev.next = res1;
            prev = res1;
            l1 = l1.next;
            l2 = l2.next;
        }
        
         while(l1 != null){
            int sum = l1.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
                //System.out.println(" sum : " + sum + " carry : " + carry);
            } else {
                carry = 0;
                
            }
            ListNode res1 = new ListNode(sum);
            prev.next = res1;
            prev = res1;
            l1 = l1.next;
         }
        
        while(l2 != null){
            int sum = l2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum % 10;
                //System.out.println(" sum : " + sum + " carry : " + carry);
            } else {
                carry = 0;
                
            }
            ListNode res1 = new ListNode(sum);
            prev.next = res1;
            prev = res1;
            l2 = l2.next;
         }
        
        if(carry > 0){
            ListNode res1 = new ListNode(carry);
            prev.next = res1;
        }
        return res.next;
    }
}