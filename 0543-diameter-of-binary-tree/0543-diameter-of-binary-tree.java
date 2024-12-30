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
    public int diameterOfBinaryTree(TreeNode root) {
        int a[] = new int[1];
        recu(root,a);
        return a[0];
    }

    public int recu (TreeNode root,int a[]){
        if (root == null)
            return 0;

        int leftH = recu(root.left,a);
        int rightH = recu(root.right,a);
        a[0] = Math.max(a[0],leftH + rightH);
        return 1 + Math.max(leftH , rightH);
    }
}