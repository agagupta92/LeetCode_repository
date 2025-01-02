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
    private int inOrder(TreeNode root, int k, int[] cnt){
        if(root==null){
            return -1;
        }
        // check in left-subtree
        int left=inOrder(root.left, k, cnt);
        // increment the count when reach at each smallest node of inOrder traversal
        cnt[0]++;
        // if the current node is kth smallest then return its val
        if(cnt[0]==k){
            return root.val;
        }
        // check in right-subtree
        int right=inOrder(root.right, k, cnt);

        // if kth smallest is in left-subtree then return left else return right
        return left!=-1 ? left : right;
    }
    public int kthSmallest(TreeNode root, int k) {
        // cnt to store the count of traverse nodes
        int[] cnt={0};
        return inOrder(root, k, cnt);
    }
}