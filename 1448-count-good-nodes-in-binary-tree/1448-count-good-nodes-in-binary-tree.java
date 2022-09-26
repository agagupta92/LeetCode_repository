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
    public int goodNodes(TreeNode root) {
         return countGoodNodes(root, Integer.MIN_VALUE);
    }
    
    private int countGoodNodes(TreeNode node, int high) {
        if(node == null) return 0;
        
        return ((node.val < high ) ? 0 : 1) 
                + countGoodNodes(node.left, Math.max(high, node.val))
                + countGoodNodes(node.right, Math.max(high, node.val));

    }
}