/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    public TreeNode helper(LinkedList<String> queue){

        String s = queue.poll();
        if(s.equals("null")) return null;

        TreeNode out = new TreeNode(Integer.valueOf(s));
        out.left = helper(queue);
        out.right = helper(queue);

        return out;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));