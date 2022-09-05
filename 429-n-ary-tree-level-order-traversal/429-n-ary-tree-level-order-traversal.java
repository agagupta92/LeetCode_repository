/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> nm=new ArrayList<List<Integer>>();
    if(root==null)
        return nm;
    Queue<Node> kk=new LinkedList<>();
    kk.offer(root);
    while(!kk.isEmpty())
    {
        int p=kk.size();
        ArrayList<Integer> k=new ArrayList<>();
        for(int i=0;i<p;i++)
        {
            k.add(kk.peek().val);
            for(Node f:kk.peek().children)
            {
                kk.offer(f);
            }
            kk.poll();
        }
        nm.add(new ArrayList<>(k));
    }
    return nm;
    }
}