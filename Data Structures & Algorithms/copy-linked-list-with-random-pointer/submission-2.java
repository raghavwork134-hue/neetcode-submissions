/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // if (head == null)
        //     return null;

        // HashMap<Node, Node> map = new HashMap<>();

        // // Pass 1: Create copy of every node
        // Node curr = head;

        // while (curr != null) {
        //     map.put(curr, new Node(curr.val));
        //     curr = curr.next;
        // }

        // // Pass 2: Set next and random pointers
        // curr = head;

        // while (curr != null) {

        //     Node copy = map.get(curr);

        //     copy.next = map.get(curr.next);

        //     copy.random = map.get(curr.random);

        //     curr = curr.next;
        // }

        // return map.get(head);

        if(head == null){
            return null;
        }

        Node curr = head;
        
        while(curr != null){
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        // set random pointers
        curr = head;
        while(curr != null){

            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // separate copied nodes
        curr  = head;
        Node dummy = new Node(0);
        Node copycurr = dummy;

        while(curr != null){
            Node copy = curr.next;
            curr.next = copy.next;
            copycurr.next = copy;
            copycurr = copy;

            curr = curr.next;
        }
        return dummy.next;

    }
}
