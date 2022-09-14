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
      
int ispalindromecount = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        ispalindromecount = 0;
        dfsearch(root, 0);
        return ispalindromecount;
    }
    
    public void dfsearch(TreeNode root, int count) {
        if (root == null) return;
        count ^= 1 << (root.val - 1);
        dfsearch(root.left, count);
        dfsearch(root.right, count);
        if (root.left == null && root.right ==  null && (count & (count - 1)) == 0) ispalindromecount++;
    }
}