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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int i=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            i++;
        }
        k=k%i;
        if(k==0){
            return head;
        }
        k=i-k;
        temp=head;
        
        ListNode ans=head;
        ListNode temp2=null;
        while(temp.next!=null){
            if(k==1){
                temp2=temp;
            }
            temp=temp.next;
            k--;
            if(k==0){
                head=temp;
            }
        }
        temp2.next=null;
        temp.next=ans;
        return head;
    }
}