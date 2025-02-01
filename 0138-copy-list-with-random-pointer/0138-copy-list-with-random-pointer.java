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

public class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node cur = head;
        while (cur != null) {
            if (!oldToCopy.containsKey(cur)) {
                oldToCopy.put(cur, new Node(0));
            }
            oldToCopy.get(cur).val = cur.val;

            if (!oldToCopy.containsKey(cur.next)) {
                oldToCopy.put(cur.next, new Node(0));
            }
            oldToCopy.get(cur).next = oldToCopy.get(cur.next);

            if (!oldToCopy.containsKey(cur.random)) {
                oldToCopy.put(cur.random, new Node(0));
            }
            oldToCopy.get(cur).random = oldToCopy.get(cur.random);
            cur = cur.next;
        }
        return oldToCopy.get(head);
    }
}