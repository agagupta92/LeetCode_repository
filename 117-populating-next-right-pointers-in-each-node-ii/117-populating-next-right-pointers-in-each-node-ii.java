/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         if(root == null) return null;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty())
        {
            //create a node max to store the right-most node
            Node max = new Node(0);
            int size = queue.size();
            for(int k = 0; k  <size ; k++)
            {
                Node temp = queue.poll();
                //since we start from the right, the first node of the queue will be the max node.
                if(k==0){
                    temp.next = null;
                    max = temp;
                    }
                else{
                    temp.next = max;
                    max = temp;
                }
                //add node to queue in right to left order
                if(temp.right != null) queue.add(temp.right);
                if(temp.left != null) queue.add(temp.left);
            }        
        }
        return root;
    }
}