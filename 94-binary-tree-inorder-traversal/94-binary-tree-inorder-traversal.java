/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> res  = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st= new Stack<TreeNode>();
        
        TreeNode cur = root ;
        
        while(true){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            } else {
                if(st.isEmpty())
                    break;
                
                cur = st.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            
        }
        
        return res;
    }
}