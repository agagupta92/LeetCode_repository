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
    public List<Integer> rightSideView(TreeNode root) {
        
         List<Integer> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            
            int size = qu.size();
             TreeNode tmp = null;
            for(int i = 0;i < size;i++){
                
                 tmp = qu.poll();

                if(tmp != null){
                    if(tmp.left != null){
                        qu.offer(tmp.left);
                    }
                    if(tmp.right != null){
                        qu.offer(tmp.right);
                    }
                }
            }
            if(tmp != null)
                res.add(tmp.val);
            
        }
        
        return res;
    }
}