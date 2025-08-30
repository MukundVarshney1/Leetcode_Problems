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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        ListNode a=head;
        ListNode b=head;
        for(int i=1;i<k;i++){
            temp=temp.next;
        } 
        a=temp;
        while(temp.next!=null){ // like slow and fast both will update their value by 1 each 
            temp=temp.next;
            b=b.next;
        }
        int val=a.val;
        a.val=b.val;
        b.val=val;
        return head;
    }
}