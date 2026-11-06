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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;

        // ListNode slow = dummy;
        // ListNode fast = dummy;

        // // Move fast n+1 steps
        // for (int i = 0; i <= n; i++) {
        //     fast = fast.next;
        // }

        // // Move both pointers
        // while (fast != null) {
        //     slow = slow.next;
        //     fast = fast.next;
        // }

        // // Delete nth node
        // slow.next = slow.next.next;

        // return dummy.next;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0;i<=n;i++){
            fast = fast.next;
        }

        while(fast!= null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;


                        // brute force
        // List<ListNode> nodes = new ArrayList<>();
        // ListNode cur = head;
        // while (cur != null) {
        //     nodes.add(cur);
        //     cur = cur.next;
        // }

        // int removeIndex = nodes.size() - n;
        // if (removeIndex == 0) {
        //     return head.next;
        // }

        // nodes.get(removeIndex - 1).next = nodes.get(removeIndex).next;
        // return head;

        
    }
}
