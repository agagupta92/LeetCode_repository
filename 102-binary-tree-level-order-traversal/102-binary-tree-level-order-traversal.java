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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) return res;
        
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.offer(root);
        while(!qu.isEmpty()){
            List<Integer> ps = new ArrayList<>();
            int size = qu.size();
            
            for(int i =0;i < size;i++){
                TreeNode tmp = qu.poll();
                ps.add(tmp.val);
                
                if(tmp.left != null)
                    qu.offer(tmp.left);
                
                if(tmp.right != null)
                    qu.offer(tmp.right);
            }
            res.add(ps);
        }
        return res;
    }
}