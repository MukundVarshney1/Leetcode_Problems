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
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            if(!hs.contains(curr.val)){
                if(prev==null){
                    prev=curr;
                    head=prev;
                }
                else{
                    prev.next=curr;
                    prev=curr;
                }
            }
            curr=curr.next;
        }
        prev.next=curr;
        return head;
    }
}