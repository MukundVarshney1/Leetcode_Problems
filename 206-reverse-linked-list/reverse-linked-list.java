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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        return helper(head,null);
    }
    public ListNode helper(ListNode head,ListNode prev){
        if(head.next==null){
            head.next=prev;
            return head;
        }
        ListNode temp=helper(head.next,head);
        head.next=prev;
        return temp;


    }
}