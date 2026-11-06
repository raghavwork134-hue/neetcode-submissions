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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;

        // ListNode groupPrev = dummy;

        // while (true) {

        //     // Find kth node
        //     ListNode kth = groupPrev;

        //     for (int i = 0; i < k && kth != null; i++) {
        //         kth = kth.next;
        //     }

        //     if (kth == null)
        //         break;

        //     ListNode groupNext = kth.next;

        //     // Reverse group
        //     ListNode prev = groupNext;
        //     ListNode curr = groupPrev.next;

        //     while (curr != groupNext) {

        //         ListNode temp = curr.next;

        //         curr.next = prev;

        //         prev = curr;

        //         curr = temp;
        //     }

        //     // Connect with previous group
        //     ListNode temp = groupPrev.next;

        //     groupPrev.next = kth;

        //     groupPrev = temp;
        // }

        // return dummy.next;        

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupprev = dummy;
        while(true){
            ListNode kth = groupprev;
            for(int i = 0;i<k && kth != null;i++){
                kth = kth.next;
            }

            if(kth == null){
                break;
            }

            ListNode groupnext = kth.next;

            ListNode prev = groupnext;
            ListNode curr = groupprev.next;

            while(curr != groupnext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupprev.next;
            groupprev.next = kth;
            groupprev = temp;
        }
        return dummy.next;
    }
}
