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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            double sum = 0.0;
            for(int i =0;i<size;i++){
                TreeNode nd = que.poll();
                sum += nd.val;
                if(nd.left != null)
                    que.add(nd.left);
                if(nd.right != null)
                    que.add(nd.right);
            }
            ans.add(sum/size);
        }
        return ans;
    }
}